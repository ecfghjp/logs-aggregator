package com.ecfghjp.aggregator.logs.adapter.dao.model;

import java.util.List;

//can use Lombok to autogenerate everything
//Only getters to make this class immutable
public class LogInformation{
	
	List<String> logs;

	public LogInformation(List<String> logs) {
		this.logs = logs;
	}

	public List<String> getLogs() {
		return logs;
	}
}
