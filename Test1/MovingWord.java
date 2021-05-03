package Test1;

import java.util.Scanner;

public class MovingWord {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String text = scnr.nextLine();
		String[] words = text.split(" ");
		String first = words[0];
		for (int i = 0; i < words.length - 1; i++) {
			words[i] = words[i + 1];
		}
		words[words.length - 1] = first;
		for (int i = 0; i < words.length; i++) {
			if (i == 0) {
				words[0] = words[0].substring(0, 1).toUpperCase() + words[0].substring(1);
				System.out.print(words[0] + " ");
			} else {
				System.out.print(words[i] + " ");
			}
		}
		scnr.close();
	}
	// System.out.println("Enter a line of text. No puncuation please.");

	// Scanner Input=new Scanner(System.in);
	// String Text=Input.nextLine();
	// int Breakpoint=Text.indexOf(' ');
	// String ShiftedText=Text.substring(Breakpoint+1,Text.length())+"
	// "+Text.substring(0,Breakpoint);

	// System.out.println("I have rephrased that line to read:");
	// System.out.println(ShiftedText);
}
