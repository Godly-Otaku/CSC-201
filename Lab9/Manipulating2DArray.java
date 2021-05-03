package Lab9;

import java.util.*;

public class Manipulating2DArray {
	public static void main(String[] args) {
		int[][] ten = new int[5][11];
		addTo10(ten);
		int[][] mines = new int[6][6];
		for (int i = 0; i < mines.length; i++) {
			for (int j = 0; j < mines[i].length; j++) {
				int ran = (int) (Math.random() * 5) + 1;
				if (ran == 5) {
					mines[i][j] = -1;
				}
			}
		}
		System.out.println();
		setHints(mines);
	}

	public static void addTo10(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			int div = 10 / array[i].length;
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = div;
			}
			if (div * array[i].length != 10) {
				int remain = 10 % array[i].length;
				array[i][0] += remain;
			}
		}
	}

	public static void setHints(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			level2: for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] == -1) // if it's a mine
					continue;
				level3: for (int q = -1; q <= 1; q++) {
					level4: for (int z = -1; z <= 1; z++) {
						if ((j == 0) && (z == -1)) {// too far left
							continue level4;
						}
						if ((i == 0) && (q == -1)) {// too high
							continue level3;
						}
						if ((j == (array[i].length - 1)) && (z == 1)) {// too far right
							continue level3;
						}
						if ((i == (array.length - 1)) && (q == 1)) {// too low
							continue level2;
						}
						if (array[i + q][j + z] == -1)
							array[i][j] += 1;
					}
				}
			}
		}
		print(array);
	}

	public static void print(int[][] array) {
		String lineSplit = "";
		StringJoiner splitJoiner = new StringJoiner("+", "|", "|");
		for (int index = 0; index < array[0].length; index++) {
			splitJoiner.add(String.format("%4s", "").replace(" ", "-"));
		}
		lineSplit = splitJoiner.toString();
		for (int[] row : array) {
			StringJoiner sj = new StringJoiner(" | ", "| ", " |");
			for (int col : row) {
				sj.add(String.format("%02d", col));
			}
			System.out.println(lineSplit);
			System.out.println(sj.toString());
		}
		System.out.println(lineSplit);
		// for (int i = 0; i < array.length; i++) {
		// for (int x : array[i]) {
		// System.out.print("|" + x);
		// }
		// System.out.println("|");
		// }
	}
}