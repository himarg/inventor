package com.himarg.inventory.dbservice.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.himarg.inventory.dbservice.entities.Transactions;

public interface TransactionsRepository extends PagingAndSortingRepository<Transactions, Long>{

}
