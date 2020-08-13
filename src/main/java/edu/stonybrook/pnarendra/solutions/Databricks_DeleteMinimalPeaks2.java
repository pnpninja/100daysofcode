package edu.stonybrook.pnarendra.solutions;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Databricks_DeleteMinimalPeaks2 {

	class PeakPosition{
		public int peak;
		public int position;
	}
	
	PriorityQueue<PeakPosition> peaksMinHeap = new PriorityQueue<PeakPosition>(new Comparator<PeakPosition>() {
		public int compare(PeakPosition o1, PeakPosition o2) {
			return o1.peak - o2.peak;
		}
	});
}
