package com.ecfghjp.aggregator.logs.adapter.exception;

//Exception genertator class
public class LogsAggregatorException {

	private LogAggregatorBusinessException businessException;
	private LogAggregatorTechnicalException technicalException;

	public LogsAggregatorException() {
	}

	public LogAggregatorBusinessException getBusinessException() {
		return businessException;
	}

	public void setBusinessException(LogAggregatorBusinessException businessException) {
		this.businessException = businessException;
	}

	public LogAggregatorTechnicalException getTechnicalException() {
		return technicalException;
	}

	public void setTechnicalException(LogAggregatorTechnicalException technicalException) {
		this.technicalException = technicalException;
	}

}
