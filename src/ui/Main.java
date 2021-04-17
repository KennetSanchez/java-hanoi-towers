package ui;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

import model.Operations;

public class Main {

	public static void main(String[] args) throws IOException {

		Operations op;

		int disks = 0;

		String solution = "";

		// Input.
		BufferedReader br = new BufferedReader(new FileReader("docs/input.txt"));

		// Output file.
		FileOutputStream fos = new FileOutputStream("docs/output.txt");
		PrintStream ps = new PrintStream(fos);

		System.out.println("How many attemps are you going to do?");
		int times = Integer.parseInt(br.readLine());

		for (int i = 0; i < times; i++) {
			//This makes the program useful if there's another input (different from the input file).
			System.out.println("How many disks are in the first tower?");
			disks = Integer.parseInt(br.readLine());
			

			op = new Operations(disks);
			solution = op.solve(disks, 1, 2, 3);

			System.out.println(solution);		
			System.out.println();
			
			//This makes the output of the program, and the verified output match. If it's the last solution, it won't print the "\n".
			if(i == times-1) {
				ps.print(solution);
			}else {
				ps.print(solution + "\n");
			}
		}
		
		br.close();
		ps.close();
	}

}
