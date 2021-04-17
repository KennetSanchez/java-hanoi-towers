package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import model.Operations;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Operations op;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		System.out.println("How many attemps are you going to do?");
		int times = Integer.parseInt(br.readLine());
		int disks = 0;
		
		for(int i = 0; i < times ; i++) {
			System.out.println("How many disks are in the first tower?");
			disks = Integer.parseInt(br.readLine());;
			
			op = new Operations(disks);
			bw.write(op.solve(disks, 1, 2, 3));
			bw.write("Done. \n" );
		}
		
		br.close();
		bw.close();
	}

}
