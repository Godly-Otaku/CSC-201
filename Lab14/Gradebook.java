package Lab14;

import java.io.*;
import java.util.*;

public class Gradebook {
	private String[] labels;
	private int[][] grades;
	int[] avg;

	public Gradebook(File file) {
		Scanner scnr;
		try {
			scnr = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("Sorry! but this file does not exist. Please check file name and try again");
			return;
		}
		String[] NM = scnr.nextLine().split(" ");
		int numOfStu = Integer.parseInt(NM[0]);
		int numOfGrade = Integer.parseInt(NM[1]);
		labels = scnr.nextLine().split(" ");
		grades = new int[numOfStu][numOfGrade];
		avg = new int[numOfStu];
		for (int i = 0; i < numOfStu; i++) {
			int sum = 0;
			for (int j = 0; j < numOfGrade; j++) {
				grades[i][j] = scnr.nextInt();
				sum += grades[i][j];
			}
			avg[i] = sum / numOfGrade;
		}
	}

	public void print() {
		for (int i = 0; i < grades[0].length; i++) {
			System.out.print(labels[i] + "\t");
		}
		System.out.print("Unweighted Average");
		System.out.println("\n------------------------------------------");
		for (int i = 0; i < grades.length; i++) {
			for (int j = 0; j < grades[i].length; j++) {
				System.out.print(grades[i][j] + "\t");
			}
			System.out.println(avg[i]);
			System.out.println();
		}
	}

	public static void main(String[] args) {
		File file = new File(args[0]);
		Gradebook gb = new Gradebook(file);
		gb.print();
	}
}