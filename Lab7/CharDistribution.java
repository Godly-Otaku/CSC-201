package Lab7;

import java.util.Scanner;
import java.io.*;

public class CharDistribution {
	public static void main(String[] args) throws Exception {
		File file = new File("test.txt");
		int[] c = charCounting(file);
		print(c);
	}

	public static int[] charCounting(File file) throws Exception {
		char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		int[] amounts = new int[26];
		Scanner scnr = new Scanner(file);
		String text = "";
		while (scnr.hasNextLine()) {
			text += scnr.nextLine() + " ";
		}
		String[] words = text.split(" ");
		for (int i = 0; i < 26; i++) { // each letter of alphabet
			for (String x : words) { // each word in file
				char[] letters = x.toUpperCase().toCharArray();
				for (int j = 0; j < letters.length; j++) { // each letter of each word in file
					if (letters[j] == alphabet[i])
						amounts[i]++;
				}
			}
		}
		scnr.close();
		return amounts;
	}

	public static void print(int[] c) {
		for (int i = 0; i < 26; i++) {
			int num = 65 + i;
			char letter = (char) num;
			System.out.println(letter + ": " + c[i]);
		}
	}
}