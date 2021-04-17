package model;

import java.util.ArrayList;

public class Operations {

	final static int TOWERS_AMOUNT = 3;

	public int[] towers;

	int disks = 0;
	int total = 0;
	String info = "";
	boolean finished;
	
	final static int TOWER1 = 0;
	final static int TOWER2 = 1;
	final static int TOWER3 = 2;

	
	public Operations(int total) {
		disks = total;

		towers = new int[TOWERS_AMOUNT];
		towers[TOWER1] = disks;
		towers[TOWER2] = 0;
		towers[TOWER3] = 0;
	}

	public String solve(int disksP, int origin, int aux, int target) {

		if (disksP > 0) {
			solve(disksP - 1, origin, target, aux);
			towers[origin-1]--;
			towers[target-1]++;
			info += towers[TOWER1] + " " + towers[TOWER2] + " " + towers[TOWER3] + "\n";
			solve(disksP - 1, aux, origin, target);
		}
		
		return info;
	}
}
