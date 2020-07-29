package edu.stonybrook.pnarendra.medium;

import java.util.HashMap;
import java.util.Map;

// 535
// https://leetcode.com/problems/encode-and-decode-tinyurl/
public class URLEncoder {
	public class Codec {

	    Map<String, String> hashmap = new HashMap<String, String>();
	    int counter = 0;
	    // Encodes a URL to a shortened URL.
	    public String encode(String longUrl) {
	    	counter++;
	        hashmap.put(Integer.toString(counter),longUrl);
	        return Integer.toString(counter);
	    }

	    // Decodes a shortened URL to its original URL.
	    public String decode(String shortUrl) {
	        return hashmap.get(shortUrl);
	    }
	}
}
