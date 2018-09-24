package com.himarg.stockapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.himarg.stockapp.entities.StockItem;
import com.himarg.stockapp.services.StockService;

@RestController
@RequestMapping("/v1/stock")
public class StockController {
	
	@Autowired
	StockService stockService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addStockItem(@RequestBody StockItem stockItem){
		this.stockService.addStockItem(stockItem);
	}
	
	@RequestMapping(value = "/{stockItemId}", method = RequestMethod.GET)
	public StockItem getStockItem(@PathVariable Long stockItemId){
		return this.stockService.getStockItem(stockItemId);
	}
	
	@RequestMapping(value = "/search/{name}", method = RequestMethod.GET)
	public List<StockItem> getStockItems(@PathVariable String name){
		return this.stockService.getStockItems(name, 0, 10);
	}
	
	@RequestMapping(value = "/searchPages/{name}/{pageNum}/{count}", method = RequestMethod.GET)
	public List<StockItem> getStockItems(@PathVariable String name, @PathVariable int pageNum, @PathVariable int count){
		return this.stockService.getStockItems(name, pageNum, count);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void updateStockItem(@RequestBody StockItem stockItem){
		this.stockService.addStockItem(stockItem);
	}
	
	@RequestMapping(value = "/{stockItemId}", method = RequestMethod.DELETE)
	public void deleteStockItem(@PathVariable Long stockItemId){
		this.stockService.deleteStockItem(stockItemId);
	}
}
