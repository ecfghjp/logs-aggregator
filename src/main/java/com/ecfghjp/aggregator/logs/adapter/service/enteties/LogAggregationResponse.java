package com.ecfghjp.aggregator.logs.adapter.service.enteties;

import com.ecfghjp.aggregator.logs.adapter.exception.LogsAggregatorException;

public class LogAggregationResponse {

	private boolean response;
	private LogsAggregatorException logsAggregatorException;

	public LogAggregationResponse() {
	}

	public LogAggregationResponse(boolean response, LogsAggregatorException logsAggregatorException) {
		super();
		this.response = response;
		this.logsAggregatorException = logsAggregatorException;
	}

	public boolean isResponse() {
		return response;
	}

	public LogsAggregatorException getLogsAggregatorException() {
		return logsAggregatorException;
	}

}
