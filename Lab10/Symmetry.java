package Lab10;

public class Symmetry {
	public static void main(String[] args) {
		symmetricNumber(1);
		symmetricNumber(2);
		symmetricNumber(5);
		symmetricNumber(6);
		symmetricNumber(9);
		symmetricNumber(10);
		symmetricNumber(12);
	}

	public static void symmetricNumber(int n) {
		int half = ((n + 1) / 2);
		String output = "";
		if (n == 1) {
			output = "1";
		} else {
			for (int i = half; i >= 1; i--) {
				output += i;
			}
			if (n % 2 != 0) {
				for (int i = 2; i <= half; i++) {
					output += i;
				}
			} else {
				for (int i = 1; i <= half; i++) {
					output += i;
				}
			}
		}
		System.out.println(output);
	}
}