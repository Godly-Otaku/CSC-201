package Lab0;

import java.util.*;
import java.io.*;

public class FindInFile {
	public static void main(String[] args) throws Exception {
		String name = args[0];
		String looking = args[1];
		File file = new File("C:\\CSC201\\Lab0\\" + name);
		Scanner scnr = new Scanner(file);
		String text = "";
		while (scnr.hasNextLine()) {
			text += scnr.nextLine() + " ";
		}
		String[] words = text.split(" ");
		int c = 0;
		for (String x : words) {
			if (x.endsWith(looking))
				c++;
		}
		System.out.println("There are " + c + " words in " + name + " that end with \"" + looking + "\"");
		scnr.close();
	}
}