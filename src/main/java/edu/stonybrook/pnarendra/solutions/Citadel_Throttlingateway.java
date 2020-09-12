package edu.stonybrook.pnarendra.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Citadel_Throttlingateway {
	
	public static final int perSecondMax = 3;
    public static final int perTenSecondsMax = 20;
    public static final int perMinuteMax = 60;
	
	public int droppedRequests(int[] requestTime) {
        if (requestTime == null || requestTime.length == 0) {
            return 0;
        }
        int drop = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int lastReqTime = 0;
        for (int i : requestTime) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            lastReqTime = Math.max(lastReqTime, i);
        }
        int[] nums = new int[lastReqTime + 1];
        Map<Integer, Integer> temp = new HashMap<Integer, Integer>();
        for (int i = 1; i < nums.length; ++i) {
            int numReqThisSecond = map.getOrDefault(i, 0);
            nums[i] = nums[i - 1] + numReqThisSecond;
            temp.put(i, temp.getOrDefault(i - 1, 0) + numReqThisSecond);
            if (numReqThisSecond == 0) {
                continue;
            }
            int toDrop = 0;
            if (numReqThisSecond > perSecondMax) {
                toDrop = Math.max(toDrop, numReqThisSecond - perSecondMax);
            }

            int timeTenSecondsAgo = Math.max(i - 10, 0);
            int numReqPastTenSecond = nums[i] - nums[timeTenSecondsAgo];
            numReqPastTenSecond = temp.getOrDefault(i, 0) - temp.getOrDefault(timeTenSecondsAgo, 0);
            if (!(numReqPastTenSecond <= perTenSecondsMax)) {
                int numReqExceeded = numReqThisSecond < (numReqPastTenSecond - perTenSecondsMax) ? numReqThisSecond : (numReqPastTenSecond - perTenSecondsMax);
                toDrop = toDrop > numReqExceeded ? toDrop : numReqExceeded;
            }

            int timeOneMinuteAgo = Math.max(i - 60, 0);
            int numReqPastMinute = nums[i] - nums[timeOneMinuteAgo];
            if (!(numReqPastMinute <= perMinuteMax)) {
                int numReqExceeded = numReqThisSecond < (numReqPastMinute - perMinuteMax) ? numReqThisSecond : (numReqPastMinute - perMinuteMax);
                toDrop = toDrop > numReqExceeded ? toDrop : numReqExceeded;
            }
            drop += toDrop;
        }
        return drop;
    }

}
