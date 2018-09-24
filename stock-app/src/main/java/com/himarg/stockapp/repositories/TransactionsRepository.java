package com.himarg.stockapp.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.himarg.stockapp.entities.Transactions;

public interface TransactionsRepository extends PagingAndSortingRepository<Transactions, Long> {

}
