package com.ecfghjp.aggregator.logs.adapter.reader;

import java.util.List;

public interface LogReader<T> {
	
	public List<T> openconnections(List<String> paths);
	public boolean closeConnection(List<T> t);
	
}
