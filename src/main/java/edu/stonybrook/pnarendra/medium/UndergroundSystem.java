package edu.stonybrook.pnarendra.medium;

import java.util.HashMap;
import java.util.Map;

class CheckInData{
	String startStation;
	int time;
	
	public CheckInData(String startStation, int time) {
		this.startStation = startStation;
		this.time = time;
	}

	public String getStartStation() {
		return startStation;
	}

	public void setStartStation(String startStation) {
		this.startStation = startStation;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}	
}

class TravelData{
	double totalTime;
	double totalTrips;
	
	public TravelData() {
		this.totalTime = 0d;
		this.totalTrips = 0d;
	}
	
	public double getAverage() {
		if(this.totalTrips == 0) {
			return 0;
		}else {
			return this.totalTime/this.totalTrips;
		}
	}
	
	public void addTrip(double timeTaken) {
		this.totalTime+=timeTaken;
		this.totalTrips++;
	}
}
public class UndergroundSystem {
	
	Map<Integer, CheckInData> checkInMap;
	Map<String, TravelData> travelDataMap;
	public UndergroundSystem() {
        this.checkInMap = new HashMap<>();
        this.travelDataMap = new HashMap<>();
	}
    public void checkIn(int id, String stationName, int t) {
        this.checkInMap.put(id, new CheckInData(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckInData data = this.checkInMap.get(id);
        TravelData travelData = this.travelDataMap.getOrDefault(data.getStartStation()+stationName, 
        		new TravelData());
        travelData.addTrip(t - data.getTime());
        travelDataMap.put(data.getStartStation()+stationName,travelData);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        return this.travelDataMap.getOrDefault(startStation+endStation, new TravelData()).getAverage();
    }

}
