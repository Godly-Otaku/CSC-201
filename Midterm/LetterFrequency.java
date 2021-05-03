package Midterm;

import java.util.*;
import java.io.*;

public class LetterFrequency {
	public static void main(String[] args) throws Exception {
		File file = new File(args[0]);
		char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		int[] c = charCounting(file, alphabet);
		print(c, alphabet);
	}

	public static int[] charCounting(File file, char[] alphabet) throws Exception {
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

	public static void print(int[] c, char[] alphabet) {
		for (int i = 0; i < 26; i++) {
			System.out.println(alphabet[i] + ": [" + c[i] + "]");
		}
	}
}
