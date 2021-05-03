package Lab5;

import java.util.Scanner;

public class GradeDistribution {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int A = 0;
		int B = 0;
		int C = 0;
		int fail = 0;
		int other = 0;
		for (int i = 0; i < 10; i++) {
			int n = scnr.nextInt();
			if (n <= 100 && n >= 90)
				A++;
			else if (n <= 89 && n >= 80)
				B++;
			else if (n <= 79 && n >= 70)
				C++;
			else if (n <= 69 && n >= 0)
				fail++;
			else
				other++;
		}
		System.out.println("Grade Range\tNo.");
		System.out.println("[90 - 100]\t" + A);
		System.out.println("[80 - 89]\t" + B);
		System.out.println("[70 - 79]\t" + C);
		System.out.println("[0 - 69]\t" + fail);
		System.out.println("Others\t\t" + other);
		scnr.close();
	}
}