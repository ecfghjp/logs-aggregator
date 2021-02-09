package com.ecfghjp.aggregator.logs.adapter;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.ecfghjp.aggregator.logs.AggregateLogs;
import com.ecfghjp.aggregator.logs.adapter.dao.FileConnection;
import com.ecfghjp.aggregator.logs.adapter.dao.LogManagerDao;
import com.ecfghjp.aggregator.logs.adapter.reader.LogFileReader;
import com.ecfghjp.aggregator.logs.adapter.reader.LogReader;
import com.ecfghjp.aggregator.logs.adapter.service.LogService;
import com.ecfghjp.aggregator.logs.adapter.service.LogServiceImpl;
import com.ecfghjp.aggregator.logs.adapter.service.enteties.LogAggregateRequest;
import com.ecfghjp.aggregator.logs.adapter.service.enteties.LogAggregationResponse;

class AggregateLogsTest {
	
	@Test
	void testMergeSameFiles() throws Exception {
		LogManagerDao connectionManager = new FileConnection("/Users/abhishek.sharma/Documents/My Learning/My Projects/GITHub/java/logs-aggregator/src/test/resources/out/out.log");
		
		LogReader<BufferedReader> reader = new LogFileReader();
		
		String path = "src/test/resources/ByDate";

		String file5 = new File(path+"/log1.log").getAbsolutePath();
		String file7 = new File(path+"/log1.log").getAbsolutePath();
		List<String> filepaths = Arrays.asList(
				file7,
				file5);		
		LogAggregateRequest logAggregateRequest = new LogAggregateRequest(filepaths, "/Users/abhishek.sharma/Documents/My Learning/My Projects/GITHub/java/logs-aggregator/src/test/resources/out.log");
		LogService logService = new LogServiceImpl(connectionManager, reader);
		AggregateLogs aggregateLogs = new AggregateLogs(logService);




		
		LogAggregationResponse abc = aggregateLogs.writeToLogFile(logAggregateRequest);
		// Projects/GITHub/java/logs-aggregator/src/main/resources/out.log");
		
		///asserts go here
		//read input file 
		
		//all cases should be covered

	}

	@Test
	void testWriteToLogFileByDate() throws Exception {
		LogManagerDao connectionManager = new FileConnection("/Users/abhishek.sharma/Documents/My Learning/My Projects/GITHub/java/logs-aggregator/src/test/resources/out/out.log");
		
		LogReader<BufferedReader> reader = new LogFileReader();
		
		String path = "src/test/resources/ByDate";

		String file1 = new File(path+"/log1.log").getAbsolutePath();
		String file2 = new File(path+"/log2.log").getAbsolutePath();
		String file4 = new File(path+"/log4.log").getAbsolutePath();
		String file5 = new File(path+"/log5.log").getAbsolutePath();

		List<String> filepaths = Arrays.asList(
				file1,
				file2,
				file4,
				file5);		
		LogAggregateRequest logAggregateRequest = new LogAggregateRequest(filepaths, "/Users/abhishek.sharma/Documents/My Learning/My Projects/GITHub/java/logs-aggregator/src/test/resources/out/out.log");
		LogService logService = new LogServiceImpl(connectionManager, reader);
		AggregateLogs aggregateLogs = new AggregateLogs(logService);
		
		//asserts go here




		
		aggregateLogs.writeToLogFile(logAggregateRequest);
		// Projects/GITHub/java/logs-aggregator/src/main/resources/out.log");

	}
	
	@Test
	void testWriteToLogFileByTime() throws IOException {
		LogManagerDao connectionManager = new FileConnection("/Users/abhishek.sharma/Documents/My Learning/My Projects/GITHub/java/logs-aggregator/src/test/resources/out/out.log");
		
		LogReader<BufferedReader> reader = new LogFileReader();
		
		String path = "src/test/resources/ByTime";

		String file1 = new File(path+"/log1.log").getAbsolutePath();
		String file2 = new File(path+"/log2.log").getAbsolutePath();
		String file4 = new File(path+"/log4.log").getAbsolutePath();
		String file5 = new File(path+"/log5.log").getAbsolutePath();

		List<String> filepaths = Arrays.asList(
				file1,
				file2,
				file4,
				file5);		
		LogAggregateRequest logAggregateRequest = new LogAggregateRequest(filepaths, "/Users/abhishek.sharma/Documents/My Learning/My Projects/GITHub/java/logs-aggregator/src/test/resources/out.log");
		LogService logService = new LogServiceImpl(connectionManager, reader);
		AggregateLogs aggregateLogs = new AggregateLogs(logService);




		
		aggregateLogs.writeToLogFile(logAggregateRequest);
		// Projects/GITHub/java/logs-aggregator/src/main/resources/out.log");

	}

}
