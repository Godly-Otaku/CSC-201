package HW;

public class BinaryToDecimal {
	public static void main(String[] args) {

		int number = Integer.parseInt(args[0]);

		int digit1 = number / 1000;
		int digit2 = (number / 100) % 10;
		int digit3 = (number / 10) % 10;
		int digit4 = number % 10;

		System.out.println((digit1 * 8) + (digit2 * 4) + (digit3 * 2) + digit4);
	}
}