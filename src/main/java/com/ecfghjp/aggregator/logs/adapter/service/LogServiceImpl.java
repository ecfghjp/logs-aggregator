package com.ecfghjp.aggregator.logs.adapter.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.ecfghjp.aggregator.logs.adapter.dao.LogManagerDao;
import com.ecfghjp.aggregator.logs.adapter.dao.model.Constants;
import com.ecfghjp.aggregator.logs.adapter.dao.model.LogInformation;
import com.ecfghjp.aggregator.logs.adapter.helper.AggregateLogsHelper;
import com.ecfghjp.aggregator.logs.adapter.reader.LogReader;

public class LogServiceImpl implements LogService {

	// Autowire in a spring managed project
	private LogManagerDao logManagerDao;
	private LogReader<BufferedReader> logFileReader;

	public LogServiceImpl(LogManagerDao logManagerDao, LogReader<BufferedReader> logFileReader) {
		this.logManagerDao = logManagerDao;
		this.logFileReader = logFileReader;
	}

	@Override
	public boolean writeLogsToDestination(List<String> inputFilePaths) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		logManagerDao.openConnection();

		// write Loigs

		final List<BufferedReader> bufferedReaders = logFileReader.openconnections(inputFilePaths);

		Map<String, BufferedReader> treemap = AggregateLogsHelper.createMapOfBufferedReaders(bufferedReaders);

		// write first line to output file
		boolean done = false;
		List<String> logs = new ArrayList<String>();

		while (!done) {

			Entry<String, BufferedReader> ent = ((TreeMap<String, BufferedReader>) treemap).firstEntry();
			BufferedReader bufferedReader = ent.getValue();
			logs.add(ent.getKey());
			treemap.remove(ent.getKey());
			String line = bufferedReader.readLine();
			if (line == null && treemap.size() == 0) {
				done = true;
			} else if (line != null) {
				treemap.put(line, bufferedReader);
			} else {
				bufferedReader.close();
			}
			if (logs.size() == Constants.MAX_RECORDS_IN_MEMORY || done == true) {
				logManagerDao.write(new LogInformation(logs));
				logs = null;
				logs = new ArrayList<String>();
			}

		}

		// close connection
		logManagerDao.close();
		boolean value = AggregateLogsHelper.closeAllInputFileBuffers(bufferedReaders);
		return value;
	}

	@Override
	public boolean runNightlySort(String sortFilePath) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(sortFilePath)));
		// break the huge file into multiple files
		int line = 0;
		List<String> filenames = new ArrayList<String>();
		List<String> data = new ArrayList<String>();
		PrintWriter printWriter = null;
		while (bufferedReader != null) {
			data.add(bufferedReader.readLine() + "\n");
			line++;
			if (line % 10000 == 0) {
				printWriter = new PrintWriter(new File(sortFilePath + "_tmp_" + line + ".txt"));
				// logWriter.writeLogsToDestination(data);
				data = null;
				data = new ArrayList<String>();
				// write data to file
				// set line number to 0
				line = 0;
			}

		}
		// logWriter.writeLogsToDestination(data);

		// call writeToLogFile post that

		return true;
	}

}
