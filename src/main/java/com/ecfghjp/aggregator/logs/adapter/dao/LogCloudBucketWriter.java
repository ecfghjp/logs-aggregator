package com.ecfghjp.aggregator.logs.adapter.dao;

import java.io.FileNotFoundException;
import java.util.List;

import com.ecfghjp.aggregator.logs.adapter.dao.model.LogInformation;

public class LogCloudBucketWriter implements LogManagerDao{


	@Override
	public void openConnection() throws FileNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean write(LogInformation logInformation) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

}
