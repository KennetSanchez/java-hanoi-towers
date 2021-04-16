package ui;

import model.Operations;

public class Main {

	public static void main(String[] args) {
		Operations op = new Operations(3);
		op.solve(true);
		System.out.println(op.getInfo());
	}

}
