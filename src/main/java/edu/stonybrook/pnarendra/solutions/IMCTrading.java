package edu.stonybrook.pnarendra.solutions;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class IMCTrading {
	
	public List<Long> getListExpiryTime(long time){
		List<Long> tempList = new ArrayList<Long>();
		tempList.add(getExpiryTime(time));
		return tempList;
	}
	
	
	private long getExpiryTime(long time) {
		long currentTime = Calendar.getInstance().getTimeInMillis();
		return time - currentTime / 1000;
	}

}
