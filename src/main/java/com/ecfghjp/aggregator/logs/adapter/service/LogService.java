package com.ecfghjp.aggregator.logs.adapter.service;

import java.io.IOException;
import java.util.List;

//write all business Logic here 
public interface LogService {

	public boolean runNightlySort(String sortFilePath) throws IOException;

	public boolean writeLogsToDestination(List<String> records) throws IOException;

}
