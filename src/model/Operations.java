package model;

import java.util.ArrayList;
import java.util.Objects;

public class Operations {

	ArrayList<Integer> tower1 = new ArrayList<Integer>();
	ArrayList<Integer> tower2 = new ArrayList<Integer>();
	ArrayList<Integer> tower3 = new ArrayList<Integer>();

	int disks = 0;
	String info = "";

	public Operations(int disks) {
		this.disks = disks;
		fillArrays();
	}

	public String getInfo() {
		return info;
	}

	public boolean solve(boolean firstP) {
		boolean finished = false;
		boolean first = false;
		int i = 0;

		if (firstP == true) {
			first = false;
		}

		if (first) {
			// Basic cases.
			if (disks == 1) {
				tower3.add(tower1.get(0));
				tower1.removeAll(tower1);
			} else if (disks == 2) {
				tower2.add(tower1.get(0));
				tower3.add(tower1.get(1));
				tower3.add(tower2.get(0));

				tower1.removeAll(tower1);
				tower2.removeAll(tower2);
			} else if (disks >= 3) {
				tower3.add(tower1.get(0));
				tower2.add(tower1.get(1));

				tower1.remove(0);
				tower1.remove(1);
			}
		}

		while (!finished) {
			if(tower3.size() == disks) {
				finished = true;
			}
			
			else if (tower1.size() - 1 > i && tower2.size() - 1 > i && tower2.get(i) < tower1.get(i)) {
				tower2.add(tower1.get(i));
				tower1.remove(i);
			} else if (tower1.size() - 1 > i && tower3.size() - 1 > i && tower3.get(i) < tower1.get(i)) {
				tower3.add(tower1.get(i));
				tower1.remove(i);
			} else if (tower3.size() - 1 > i && tower2.size() - 1 > i && tower3.get(i) < tower2.get(i)) {
				tower3.add(tower2.get(i));
				tower2.remove(i);
			}

			info += tower1.size() + " " + tower2.size() + " " + tower3.size() + "\n";
			i++;
			finished = solve(first);
		}
		return finished;
	}

	public void fillArrays() {
		for (int i = 0; i < disks; i++) {
			tower1.add(i);
		}
	}
}
