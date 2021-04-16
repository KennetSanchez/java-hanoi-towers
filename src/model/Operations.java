package model;

public class Operations {

	int tower1 = 0;
	int tower2 = 0;
	int tower3 = 0;

	int disks = 0;
	String info = "";
	boolean finished;
	
	public Operations() {
	}

	public String getInfo() {
		return info;
	}

	public void solve(int disksP, int first, int temp, int last) {
		disks = disksP;
		
		//Increase size.
		if (first == 1) {
			tower1--;
		} else if (temp == 2) {
			tower2--;
		} else if (last == 3) {
			tower3--;
		}

		//Reduce size.
		if(first == 2) {
		tower2++;
		}else if(temp == 1) {
			tower1++;
		}else if(last == 3) {
			tower3++;
		}
		
		
		
		
		if (disks == 1) {
			finished = true;
		}
		else if(!finished){
			solve(disks - 1, first, last, temp);
			System.out.println(tower1 + " " + tower2 + " " + tower3 + "\n");
			solve(disks - 1, temp, first, last);
		}
	}
}
