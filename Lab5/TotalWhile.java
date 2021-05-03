package Lab5;

public class TotalWhile {
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		int M = Integer.parseInt(args[1]);
		int sum = 0;
		int i = N;
		while (i <= M) {
			sum += i;
			i++;
		}
		System.out.println("Total: " + sum);
	}
}