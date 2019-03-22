package com.ceiba.todo.exception;

import org.pmw.tinylog.Logger;


public class TransactionException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public TransactionException(String message) {
        super(message);
        Logger.error("Error - ", message);
    }
	
	public TransactionException(String message, Throwable cause) {
		super(message, cause);
		Logger.error(cause, "Error - ", "");
    }
	
}