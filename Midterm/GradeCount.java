package Midterm;

import java.util.Scanner;
import java.io.*;

public class GradeCount {
	public static void main(String[] args) throws Exception {
		File file = new File(args[0]);
		Scanner scnr = new Scanner(file);
		int A = 0, B = 0, C = 0, D = 0, fail = 0, other = 0;
		while (scnr.hasNextInt()) {
			int n = scnr.nextInt();
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
			else
				other++;
		}
		System.out.println("Grade Range\tNo.");
		System.out.println("[90 - 100]\t" + A);
		System.out.println("[80 - 89]\t" + B);
		System.out.println("[70 - 79]\t" + C);
		System.out.println("[60 - 69]\t" + D);
		System.out.println("[0<69]\t\t" + fail);
		System.out.println("[Invalid]\t\t" + other);
		scnr.close();
	}
}
