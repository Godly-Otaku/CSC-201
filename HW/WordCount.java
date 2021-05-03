package HW;

import java.util.Scanner;
import java.io.*;

public class WordCount {
	public static void main(String[] args) throws Exception {
		File file = new File(args[0]);
		String look = args[1];
		int times = countWord(look, file);
		System.out.println("\"" + look + "\" appeared " + times + " time(s)");
	}

	public static int countWord(String word, File file) throws Exception {
		Scanner scnr = new Scanner(file);
		String text = "";
		while (scnr.hasNextLine()) {
			text += scnr.nextLine() + " ";
		}
		String[] words = text.split(" ");
		int sum = 0;
		for (String x : words) {
			if (x.toLowerCase().equals(word.toLowerCase()))
				sum++;
		}
		scnr.close();
		return sum;
	}
}