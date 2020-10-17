package edu.stonybrook.pnarendra.medium;

import java.util.Arrays;

public class PrisonCellsAfterNDays {

	public int[] prisonAfterNDays(int[] cells, int N) {
		if (N == 0) {
			return cells;
		} else {
			int iter = N;
			while (iter > 0) {
				// set to some numbers
				// 0 - unoccupied old
				// 1 - occupied old
				// 2 - unoccupied old unoccupied next
				// 3 - unoccupied old occupied next
				// 4 - occupied old unoccupied next
				// 5 - occupied old occupied next

				for (int i = 1; i < cells.length - 1; i++) {
					if ((cells[i - 1] == 0 || 
						cells[i - 1] == 2 || 
						cells[i - 1] == 3)
						&& 
						(cells[i + 1] == 0 || 
						cells[i + 1] == 2 || 
						cells[i + 1] == 3)) {
							if (cells[i] == 0) {
								cells[i] = 3;
							} else {
								cells[i] = 5;
							}
						}else if((cells[i - 1] == 1 || 
								cells[i - 1] == 4 || 
								cells[i - 1] == 5)
								&& 
								(cells[i + 1] == 1 || 
								cells[i + 1] == 4 || 
								cells[i + 1] == 5)) {
							if (cells[i] == 0) {
								cells[i] = 3;
							} else {
								cells[i] = 5;
							}
							
						}else {
							if(cells[i] == 1) {
								cells[i] = 4;
							}else {
								cells[i] = 2;
						}

					}
				}
				if (iter == N) {
					cells[0] = 0;
					cells[cells.length - 1] = 0;
				}
				
				//format array to new values
				for(int i = 1; i < cells.length - 1; i++) {
					if(cells[i] == 2) {
						cells[i] = 0;
					}else if(cells[i] == 3) {
						cells[i] = 1;
					}else if(cells[i] == 4) {
						cells[i] = 0;
					}else if(cells[i] == 5) {
						cells[i] = 1;
					}
				}
				iter--;
			}
			return cells;
		}
	}

}
