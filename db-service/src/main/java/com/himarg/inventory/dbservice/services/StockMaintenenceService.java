package com.himarg.inventory.dbservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.himarg.inventory.dbservice.entities.StockItem;
import com.himarg.inventory.dbservice.repository.StockItemRepository;

@RestController
@RequestMapping("/stock")
public class StockMaintenenceService {

	@Autowired
	private StockItemRepository stockItemRepository;
	
	@RequestMapping(value = "/addStockItem", method = RequestMethod.POST)
	public void addStockItem(@RequestBody StockItem stockItem){
		this.stockItemRepository.save(stockItem);
	}
	
	@RequestMapping(value = "/{stockItemId}", method = RequestMethod.GET)
	public StockItem getStockItem(@PathVariable Long stockItemId){
		return this.stockItemRepository.findOne(stockItemId);
	}
	
	@RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
	public StockItem getStockItemByName(@PathVariable String name){
		//return this.stockItemRepository.findByNameIgnoreCase(name);
		return this.stockItemRepository.findByNameLikeIgnoreCase("%"+name+"%");
	}
	
	@RequestMapping(value = "/getStockItems", method = RequestMethod.GET)
	public List<StockItem> getStockItems(){
		return this.stockItemRepository.findAll();
	}
}
