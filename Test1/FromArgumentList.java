package Test1;

public class FromArgumentList {
	public static void main(String[] args) {
		int c = 0;
		for (int i = 0; i < 4; i++) {
			if (Integer.parseInt(args[i]) % 2 == 0) {
				c++;
			}
		}
		System.out.println("Amount of even numbers: " + c);
	}
}