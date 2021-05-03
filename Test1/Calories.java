package Test1;

public class Calories {
	public static void main(String[] args) {
		String gender = args[0];
		int weight = Integer.parseInt(args[1]);
		int height = Integer.parseInt(args[2]);
		int age = Integer.parseInt(args[3]);
		double bmr = 0;
		if (gender.toLowerCase().equals("female")) {
			bmr = 655 + (4.3 * weight) + (4.7 * height) - (4.7 * age);
		} else if (gender.toLowerCase().equals("male")) {
			bmr = 66 + (6.3 * weight) + (12.9 * height) - (6.8 * age);
		} else {
			System.exit(0);
		}
		System.out.println("Bmr: " + bmr);
	}
}
