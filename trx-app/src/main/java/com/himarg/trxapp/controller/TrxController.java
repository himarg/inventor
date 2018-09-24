package com.himarg.trxapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.himarg.trxapp.model.Manufacturer;
import com.himarg.trxapp.model.StockItem;
import com.himarg.trxapp.model.UnitOfMeasure;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@RequestMapping("/v1/trx")
public class TrxController {
	
	@Autowired
	RestTemplate restTemplate; 

	@HystrixCommand(fallbackMethod = "getStockItemFallback", commandProperties = {
		     @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000") 
		})
	@RequestMapping(value = "/{stockItemId}", method = RequestMethod.GET)
	public StockItem getStockItem(@PathVariable Long stockItemId){
		ResponseEntity<StockItem> restExchange = restTemplate.exchange(
				"http://stock-app/v1/stock/{stockItemId}",
				HttpMethod.GET,
				null,
				StockItem.class,
				stockItemId
				);
		return restExchange.getBody();
	}
	
	public StockItem getStockItemFallback(Long stockItemId){
		return new StockItem(stockItemId, "Test", new UnitOfMeasure(1L, "Kgs"), 100, 100, null, new Manufacturer(1L, "Test"), null);
	}
}
