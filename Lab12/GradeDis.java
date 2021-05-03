package Lab12;

import java.util.Scanner;
import java.io.*;

public class GradeDis {
	public static void main(String[] args) {
		Scanner scnr;
		try {
			File file = new File(args[0]);
			scnr = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("Sorry! but this file does not exist. Please check file name and try again");
			return;
		}

		int A = 0, B = 0, C = 0, D = 0, fail = 0;
		while (scnr.hasNextLine()) {
			int n = 0;
			try {
				n = Integer.parseInt(scnr.next());
			} catch (Exception e) {
				continue;
			}
			if (n <= 100 && n >= 90)
				A++;
			else if (n <= 89 && n >= 80)
				B++;
			else if (n <= 79 && n >= 70)
				C++;
			else if (n <= 69 && n >= 60)
				D++;
			else if (n <= 59 && n >= 0)
				fail++;

		}
		System.out.println("Grade Range\tNo.");
		System.out.println("[90 - 100]\t" + A);
		System.out.println("[80 - 89]\t" + B);
		System.out.println("[70 - 79]\t" + C);
		System.out.println("[60 - 69]\t" + D);
		System.out.println("[Below 60]\t" + fail);
		scnr.close();
	}
}