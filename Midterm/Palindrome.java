package Midterm;

//I wasn't sure if we were supposed to count special characters at the end
import java.util.*;
import java.io.*;

public class Palindrome {
	public static void main(String[] args) throws Exception {
		File file = new File(args[0]);
		Scanner scnr = new Scanner(file);
		while (scnr.hasNextLine()) {
			boolean palin = true;
			String templine = scnr.nextLine();
			String[] words = templine.toLowerCase().split("[^A-Za-z0-9]+");
			String line = "";
			for (String x : words) {
				line += x;
			}
			for (int i = 0, j = line.length() - 1; i < j; i++, j--) {
				if (line.charAt(i) != line.charAt(j))
					palin = false;
			}
			System.out.println(templine + "\t" + palin);
		}
		scnr.close();
	}
}
