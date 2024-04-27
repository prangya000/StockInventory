package com.stockinventory.project.services;

import java.util.List;

import com.stockinventory.project.model.Stock;

public interface StockMangementService {

	List<Stock> findAllStock();

	Stock createStock(Stock stock);

	Stock findById(long id);
	
	Stock updateStock(Stock stock, long id);

	String deleteStock(long id);

	Stock findByName(String name);
	
	

}
