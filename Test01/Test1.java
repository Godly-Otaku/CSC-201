package Test01;

import java.io.*;
import java.util.*;

public class Test1 {
	public static int[] gradeStats(String gradebook) throws Exception {
		File file = new File(gradebook);
		Scanner scnr = new Scanner(file);
		int counter = 0;
		int sum = 0;
		int max = 0;
		int min = 100;
		while (scnr.hasNextInt()) {
			int num = scnr.nextInt();
			counter++;
			sum += num;
			if (num < min) // Find min
				min = num;
			if (num > max) // Find max
				max = num;
		}
		int average = sum / counter;
		int[] result = { max, min, average };
		scnr.close();
		return result;
	}

	public static int multiplesOf7(int N, int M) {
		int count = 0;
		for (int i = N; i <= M; i++) {
			if (i % 7 == 0)
				count++;
		}
		return count;
	}

	public static boolean isValidTriangle(int a, int b, int c) {
		if (((a + b) > c) && ((c + b) > a) && ((a + c) > b)) {
			return true;
		} else
			return false;
	}

	public static int binaryToInt(String binaryString) {
		int number = Integer.parseInt(binaryString, 2);
		return number;
	}

	public static int[] countWordsInEachLine(String fileName) throws Exception {
		File file = new File(fileName);
		Scanner scnr = new Scanner(file);
		int size = Integer.parseInt(scnr.nextLine());
		int[] result = new int[size];
		for (int i = 0; scnr.hasNextLine(); i++) {
			String next = scnr.nextLine();
			String[] words = next.split(" ");
			if (words[0].equals(""))
				result[i] = 0;
			else
				result[i] = words.length;
		}
		scnr.close();
		return result;
	}

	public static void main(String[] args) throws Exception {
		// System.out.println(Arrays.toString(gradeStats("gradebook.txt")));
		// System.out.println(multiplesOf7(10, 23));
		// System.out.println(isValidTriangle(3, 4, 5));
		// System.out.println(binaryToInt("0110"));
		System.out.println(Arrays.toString(countWordsInEachLine("data.txt")));
	}
}