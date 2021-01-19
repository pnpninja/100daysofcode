package edu.stonybrook.pnarendra.easy;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {
	class Logger {

		Map<String, Integer> map;
	    /** Initialize your data structure here. */
	    public Logger() {
	    	this.map = new HashMap<String,Integer>();
	    }
	    
	    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
	        If this method returns false, the message will not be printed.
	        The timestamp is in seconds granularity. */
	    public boolean shouldPrintMessage(int timestamp, String message) {
	        if(this.map.containsKey(message)) {
	        	if(this.map.get(message) > timestamp-10) {
	        		return false;
	        	}else {
	        		this.map.put(message, timestamp);
	        		return true;
	        	}
	        }else {
	        	this.map.put(message, timestamp);
	        	return true;
	        }
	    }
	}
}
