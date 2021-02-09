package com.ecfghjp.aggregator.logs.adapter.dao;

import java.io.FileNotFoundException;

import com.ecfghjp.aggregator.logs.adapter.dao.model.LogInformation;

public interface LogManagerDao {
	
	public void openConnection() throws FileNotFoundException;
	
	public boolean write(LogInformation logInformation);
	
	public void close();
}
