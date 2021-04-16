package ui;

import model.Operations;

public class Main {

	public static void main(String[] args) {
		Operations op = new Operations();
		op.solve(4, 1, 2, 3);
		System.out.println(op.getInfo());
	}

}
