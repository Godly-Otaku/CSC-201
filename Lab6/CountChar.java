package Lab6;

import java.util.Scanner;

public class CountChar {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		char look = args[0].charAt(0);
		String str = scnr.nextLine();
		int times = countChar(look, str);
		System.out.println("'" + look + "' appeared in the string \"" + str + "\" " + times + " time(s)");
		scnr.close();
	}

	public static int countChar(char c, String str) {
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == c)
				sum++;
		}
		return sum;
	}
}