package Lab5;

public class CharDistribution {
	public static void main(String[] args) {
		String input = args[0];
		char[] chars = input.toCharArray();
		int counter = 0;
		for (char letter : chars) {
			if (letter == 'A')
				counter++;
		}
		System.out.println("The character 'A' appears " + counter + " time(s)");
	}
}