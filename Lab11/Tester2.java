package Lab11;

import java.util.*;
import java.io.*;

public class Tester2 {
	public static void main(String[] args) throws Exception {
		File file = new File("student.txt");
		Scanner scnr = new Scanner(file);
		System.out.println("---------------");
		System.out.println("Student Name\t|\tGPA");
		System.out.println("----------- | ----");
		while (scnr.hasNextLine()) {
			String next = scnr.nextLine();
			String[] words = next.split(" ");
			double GPA = Double.parseDouble(words[words.length - 1]);
			String fName = "";
			for (int i = 0; i < words.length - 2; i++)
				fName += words[i];
			Student stu = new Student(fName, words[words.length - 2], GPA);
			stu.display();
		}
		System.out.println("---------------");
		scnr.close();
	}
}