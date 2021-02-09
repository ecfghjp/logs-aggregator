package com.ecfghjp.aggregator.logs.adapter.exception;

public class LogAggregatorTechnicalException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ErrorCode errorCode;

	public LogAggregatorTechnicalException(String errorMessage, Throwable cause,ErrorCode errorCode) {
		super(errorMessage, cause);
		this.errorCode = errorCode;
	}

	public LogAggregatorTechnicalException(String message, ErrorCode errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public LogAggregatorTechnicalException(Throwable cause, ErrorCode errorCode) {
		super(cause);
		this.errorCode = errorCode;
	}
	
	public ErrorCode getCode() {
		return this.errorCode;
	}

	
	// catch exceptions and encapsulate

}
