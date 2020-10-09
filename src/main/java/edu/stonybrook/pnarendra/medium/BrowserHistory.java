package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BrowserHistory {
	
	List<String> record;
	int index;
    public String toString(){
        return "List : "+Arrays.deepToString(record.toArray())+", Index : "+index;
    }
	public BrowserHistory(String homepage) {
        this.record = new ArrayList<String>();
        record.add(homepage);
        this.index = 0;
        //System.out.println(this.toString());
    }
    
    public void visit(String url) {
        //System.out.println("VISIT "+url);
        if(index < this.record.size() - 1) {
        	this.record = this.record.subList(0, index + 1);
            this.index = this.record.size() - 1;
        }
        this.record.add(url);
        this.index++;
        //System.out.println(this.toString());
    }
    
    public String back(int steps) {
        //System.out.println("BACK "+steps);
        this.index = Math.max(0, this.index - steps);
        //System.out.println(this.toString());
        return this.record.get(this.index);
    }
    
    public String forward(int steps) {
        //System.out.println("FORWARD "+steps);
    	this.index = Math.min(this.record.size() - 1, this.index + steps);
        //System.out.println(this.toString());
        return this.record.get(this.index);
    }
    

}
