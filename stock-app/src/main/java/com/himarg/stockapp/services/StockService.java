package com.himarg.stockapp.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.himarg.stockapp.entities.StockItem;
import com.himarg.stockapp.repositories.StockItemRepository;

@Service
public class StockService {

	@Autowired
	StockItemRepository stockItemRepository;
	
	public List<StockItem> getStockItems(String name, int pageNumber, int pageSize){
		return stockItemRepository.findByNameStartingWithIgnoreCase(name, PageRequest.of(pageNumber, pageSize, Direction.ASC, "name"));
	}
	
	public StockItem getStockItem(Long id) {
		Optional<StockItem> result = stockItemRepository.findById(id);
		return result.orElseThrow(() -> new NoResultException("No matching result found"));
	}
	
	public void addStockItem(StockItem stockItem){
		stockItemRepository.save(stockItem);
	}
	
	public void deleteStockItem(Long id){
		stockItemRepository.deleteById(id);
	}
}
