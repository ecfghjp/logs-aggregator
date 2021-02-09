package com.ecfghjp.aggregator.logs;

import java.io.IOException;

import com.ecfghjp.aggregator.logs.adapter.service.LogService;
import com.ecfghjp.aggregator.logs.adapter.service.enteties.LogAggregateRequest;
import com.ecfghjp.aggregator.logs.adapter.service.enteties.LogAggregationResponse;

//controller class for AggregatedLogs
public class AggregateLogs {
	private LogService logService;

	public AggregateLogs(LogService logService) {
		this.logService = logService;
	}

	public LogAggregationResponse nightlySort(String sortFilePath) throws IOException {
		try {
			boolean isFileSorted = logService.runNightlySort(sortFilePath);
			// populate if there is an exception
			return new LogAggregationResponse(isFileSorted,null);
		} catch (IOException ioe) {
			
			throw ioe;
		}
	}

	/**
	 * @param inputFilePaths
	 * @return
	 * @throws IOException Takes list of files and aggregates logs in output file
	 */
	public LogAggregationResponse writeToLogFile(LogAggregateRequest logAggregateRequest) throws IOException {
		// call service method
		// exception handlers
		try {
			boolean isLogsAggregated = logService.writeLogsToDestination(logAggregateRequest.getInputFilePaths());
			return new LogAggregationResponse(isLogsAggregated,null);
		} catch (Exception ioe) {
			throw ioe;
		}
	}

}
