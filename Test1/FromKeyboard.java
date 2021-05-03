package Test1;

import java.util.Scanner;

public class FromKeyboard {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int num1 = scnr.nextInt();
		int num2 = scnr.nextInt();
		int num3 = scnr.nextInt();
		System.out.println("---Numbers divisible by 23---");
		if (num1 % 23 == 0) {
			System.out.println(num1);
		}
		if (num2 % 23 == 0) {
			System.out.println(num2);
		}
		if (num3 % 23 == 0) {
			System.out.println(num3);
		}
		scnr.close();
	}
}
