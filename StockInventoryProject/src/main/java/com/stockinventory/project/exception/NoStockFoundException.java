package com.stockinventory.project.exception;

public class NoStockFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public NoStockFoundException(String msg) {
		super(msg);
	}
     
}
