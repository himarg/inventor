package com.himarg.inventory.dbservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.himarg.inventory.dbservice.entities.StockItem;

public interface StockItemRepository extends JpaRepository<StockItem, Long>{
	public StockItem findByNameIgnoreCase(String Name);
	
	public StockItem findByNameLikeIgnoreCase(String Name);

}
