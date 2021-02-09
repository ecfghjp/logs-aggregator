package com.ecfghjp.aggregator.logs.adapter.exception;

import java.time.LocalDateTime;

public class LogAggregatorBusinessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LocalDateTime timestamp;
	private String errorMessage;
	private ErrorCode errorCode;

	public LogAggregatorBusinessException(String errorMessage, Throwable cause,ErrorCode errorCode) {
		super(errorMessage, cause);
		this.errorCode = errorCode;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	// catch exceptions and encapsulate

}
