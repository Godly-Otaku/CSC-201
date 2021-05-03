package HW;

import java.io.*;
import java.util.*;

public class Insect {
	public static void main(String[] args) {
		File file = new File(args[0]);
		Scanner scnr;
		try {
			scnr = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("Sorry! but this file does not exist. Please check file name and try again");
			return;
		}
		int times = Integer.parseInt(scnr.nextLine().trim());
		if (times >= 1000)
			System.exit(0);
		for (int i = 0; i < times; i++) {
			String[] data = scnr.nextLine().split(" ");
			int E = Integer.parseInt(data[0]);
			double p = Integer.parseInt(data[1]);
			int R = Integer.parseInt(data[2]);
			int X = Integer.parseInt(data[3]);
			if (E > 1000 || p > 100 || R > 50 || X > 10)
				continue;
			int male = E;
			int female = E;
			if (X == 1) {
				System.out.println("Female=" + female + "\t\tMale=" + male);
				continue;
			}
			for (int j = 1; j < X; j++) {
				E = (int) Math.floor(E * (p / 100));
				female = (int) Math.floor(female * (p / 100));
				male = (int) Math.floor(male * (p / 100));
				if (R % 2 != 0) {
					male += (E * (R / 2));
					female += E * ((R / 2) + 1);
					E += E * ((R / 2) + 1);
				} else {
					E += E * (R / 2);
					male = E;
					female = E;
				}
			}
			System.out.println("Female=" + female + "\t\tMale=" + male);
		}
		scnr.close();
	}
}