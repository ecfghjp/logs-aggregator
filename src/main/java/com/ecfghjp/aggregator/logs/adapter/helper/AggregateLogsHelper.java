package com.ecfghjp.aggregator.logs.adapter.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.ecfghjp.aggregator.logs.adapter.exception.LogsAggregatorException;

public final class AggregateLogsHelper {

	public static Map<String, BufferedReader> createMapOfBufferedReaders(List<BufferedReader> bufferedReaders)
			throws IOException {
		// TODO Auto-generated method stub
		Map<String, BufferedReader> treeMap = new TreeMap<>();
		for (BufferedReader bufferedReader : bufferedReaders) {
			treeMap.put(bufferedReader.readLine(), bufferedReader);
		}
		return treeMap;
	}

	public static boolean closeAllInputFileBuffers(List<BufferedReader> bufferedReaders) {
		bufferedReaders.stream().filter(x -> x != null).forEach(x -> {
			try {
				x.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		return true;
	}

	public static LogsAggregatorException technicalException() {
		return null;

	}

	public static LogsAggregatorException businessException() {
		return null;

	}

}