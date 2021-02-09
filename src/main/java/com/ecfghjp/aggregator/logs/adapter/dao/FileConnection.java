package com.ecfghjp.aggregator.logs.adapter.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import com.ecfghjp.aggregator.logs.adapter.dao.model.Constants;
import com.ecfghjp.aggregator.logs.adapter.dao.model.LogInformation;

public class FileConnection implements LogManagerDao{
	
	private String outputFilePath;
	private PrintWriter printWriter;
	
	
	public FileConnection(String outputFilePath) {
		this.outputFilePath = outputFilePath;
	}

	@Override
	public void openConnection() throws FileNotFoundException {
		// TODO Auto-generated method stub
		this.printWriter = new PrintWriter(new File(outputFilePath));
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		printWriter.close();
		
	}

	@Override
	public boolean write(LogInformation logInformation) {
		// TODO Auto-generated method stub
		if(null!=logInformation.getLogs()) {
			logInformation.getLogs().stream()
						.forEach(log->printWriter.write(log+Constants.NEWLINE));
		}
		return true;
	}

}
