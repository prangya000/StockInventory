package com.stockinventory.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockinventory.project.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

	boolean existsByStockName(String stockName);

	Stock findByStockName(String name);

}
