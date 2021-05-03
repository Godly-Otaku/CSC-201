package Lab4;

public class Classification {
	public static void main(String[] args) {
		int input = Integer.parseInt(args[0]);
		if (input == 1) {
			System.out.println("Freshman");
		} else if (input == 2) {
			System.out.println("Sophmore");
		}
		switch (input) {
		case 1:
			System.out.println("Freshman");
			break;
		case 2:
			System.out.println("Sophmore");
			break;
		case 3:
			System.out.println("Junior");
			break;
		case 4:
			System.out.println("Senior");
			break;
		default:
			System.out.println("Invalid");
		}
	}
}