package com.stockinventory.project.exception;

public class NegativeStockFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NegativeStockFoundException(String msg) {
		super(msg);
	}
}
