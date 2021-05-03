package HW;

public class Divisible {
	public static void main(String[] args) {
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		int num3 = Integer.parseInt(args[2]);

		System.out.println("Remainder for " + num1 + ":\t" + (num1 % 21));
		System.out.println("Remainder for " + num2 + ":\t" + (num2 % 21));
		System.out.println("Remainder for " + num3 + ":\t" + (num3 % 21));
	}
}