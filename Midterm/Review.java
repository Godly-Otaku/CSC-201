package Midterm;

import java.util.*;
import java.io.*;

public class Review {
	public static void main(String[] args) throws Exception {
		String filename = args[0];
		char look = args[1].toLowerCase().charAt(0);
		int times = frequencyOfChar(look, filename);
		System.out.println("'" + look + "' appeared in the string \"" + filename + "\" " + times + " time(s)");
	}

	public static int frequencyOfChar(char c, String str) throws Exception {
		File file = new File(str);
		Scanner scnr = new Scanner(file);
		String text = "";
		while (scnr.hasNextLine()) {
			text += scnr.nextLine() + " ";
		}
		int sum = 0;
		for (int i = 0; i < text.length(); i++) {
			if (str.toLowerCase().charAt(i) == c)
				sum++;
		}
		scnr.close();
		return sum;
	}
}
