package com.stockinventory.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.stockinventory.project.constant.StockInventoryConstant;

@ControllerAdvice
public class ControllerException {
	
	@ExceptionHandler(DuplicateStockException.class)
	public ResponseEntity<StockResponse> duplicateStockFoundException(DuplicateStockException ex){
		StockResponse response= new StockResponse(
				StockInventoryConstant.DUPLICATE_STOCK,
				ex.getMessage());
		return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(NoStockFoundException.class)
	public ResponseEntity<StockResponse> noStockFoundException(NoStockFoundException ex){
		StockResponse response= new StockResponse(
				StockInventoryConstant.STOCK_NOT_AVAILABLE,
				ex.getMessage());
		return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(NegativeStockFoundException.class)
	public ResponseEntity<StockResponse> negativeStockFoundException(NegativeStockFoundException ex){
		StockResponse response= new StockResponse(
				StockInventoryConstant.NEGATIVE_SIZE_STOCK,
				ex.getMessage());
		return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
