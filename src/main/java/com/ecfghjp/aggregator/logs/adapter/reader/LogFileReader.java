package com.ecfghjp.aggregator.logs.adapter.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LogFileReader implements LogReader<BufferedReader> {

	@Override
	public List<BufferedReader> openconnections(List<String> paths) {
		final List<BufferedReader> bufferedReaders = new ArrayList<BufferedReader>();

		try {

			for (String path : paths) {
				bufferedReaders.add(new BufferedReader(new java.io.FileReader(new File(path))));
			}
		} catch (IOException ioe) {
			//log exception
			return null;
		}
		return bufferedReaders;
	}

	@Override
	public boolean closeConnection(List<BufferedReader> bufferedReader) {
			bufferedReader.stream()
						.forEach(buffer->{
							try {
							
								buffer.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							buffer=null;
						});
		return true;
	}

}
