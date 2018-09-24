package com.himarg.stockapp.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.himarg.stockapp.entities.StockItem;

public interface StockItemRepository extends PagingAndSortingRepository<StockItem, Long>{
	List<StockItem> findByNameStartingWithIgnoreCase(String name, Pageable pageRequest);
}
