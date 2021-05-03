package Lab5;

import java.util.*;
import java.io.*;

public class Summation {
	public static void main(String[] args) throws Exception {
		File file = new File("grades.txt");
		Scanner scnr = new Scanner(file);
		int sum = 0;
		while (scnr.hasNextInt()) {
			int num = scnr.nextInt();
			sum += num;
		}
		System.out.println("Sum: " + sum);
		scnr.close();
	}
}