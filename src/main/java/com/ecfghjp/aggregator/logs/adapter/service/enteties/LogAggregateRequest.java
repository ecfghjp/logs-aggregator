package com.ecfghjp.aggregator.logs.adapter.service.enteties;

import java.util.List;

public class LogAggregateRequest {
	private List<String> inputFilePaths;
	private String outputFilePath;

	public LogAggregateRequest() {
	}

	public LogAggregateRequest(List<String> inputFilePaths, String outputFilePath) {
		this.inputFilePaths = inputFilePaths;
		this.outputFilePath = outputFilePath;
	}

	public List<String> getInputFilePaths() {
		return inputFilePaths;
	}

	public String getOutputFilePath() {
		return outputFilePath;
	}

}
