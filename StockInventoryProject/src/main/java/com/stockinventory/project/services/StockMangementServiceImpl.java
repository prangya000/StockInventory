package com.stockinventory.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockinventory.project.constant.StockInventoryConstant;
import com.stockinventory.project.exception.DuplicateStockException;
import com.stockinventory.project.exception.NegativeStockFoundException;
import com.stockinventory.project.exception.NoStockFoundException;
import com.stockinventory.project.model.Stock;
import com.stockinventory.project.repository.StockRepository;

@Service
public class StockMangementServiceImpl implements StockMangementService {

	@Autowired
	private StockRepository stockRepository;

	@Override
	public List<Stock> findAllStock() {
		// TODO Auto-generated method stub
		return (List<Stock>) stockRepository.findAll();
	}

	@Override
	public Stock createStock(Stock stock) {
		if (stockRepository.existsByStockName(stock.getStockName())) {
			String msg = StockInventoryConstant.ALREADT_EXIST;
			throw new DuplicateStockException(stock.getStockName() + " " + msg);
		}
		if (!stockRepository.existsByStockName(stock.getStockName())) {
			if (stock.getStockSize()<1) {
				String msg = StockInventoryConstant.NEGATIVE_SIZE_STOCK_MSG;
				throw new NegativeStockFoundException(stock.getStockName() + " " + msg);
			}
		}
		return stockRepository.save(stock);
	}

	@Override
	public Stock findById(long id) {
		if (!stockRepository.existsById(id)) {
			String msg = StockInventoryConstant.STOCK_NOT_AVAILABLE;
			throw new NoStockFoundException(id + " " + msg);
		}
		return stockRepository.findById(id).get();
	}

	@Override
	public Stock updateStock(Stock stock, long id) {
		if (!stockRepository.existsById(id)) {
			String msg = StockInventoryConstant.STOCK_NOT_AVAILABLE;
			throw new NoStockFoundException(stock.getStockName() + " " + msg);
		}

		Stock stockNew = stockRepository.findById(id).get();
		stockNew.setStockName(stock.getStockName());
		stockNew.setStockDescription(stock.getStockDescription());
		stockNew.setStockSize(stock.getStockSize());
		return stockRepository.save(stockNew);
	}

	@Override
	public String deleteStock(long id) {
		if (!stockRepository.existsById(id)) {
			String msg = StockInventoryConstant.STOCK_NOT_AVAILABLE;
			throw new NoStockFoundException(id + " " + msg);
		}
		stockRepository.deleteById(id);
		return "Stock Delete Successfully";
	}

	@Override
	public Stock findByName(String name) {
		Stock stock = null;
		if (stockRepository.existsByStockName(name)) {
			stock = stockRepository.findByStockName(name);
		}
		return stock;
	}

}
