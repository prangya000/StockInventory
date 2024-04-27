package com.stockinventory.project.exception;

public class DuplicateStockException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DuplicateStockException(String msg) {
		super(msg);
	}
     
}
