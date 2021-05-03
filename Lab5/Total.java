package Lab5;

public class Total {
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		int M = Integer.parseInt(args[1]);
		int sum = 0;
		for (int i = N; i <= M; i++) {
			sum += i;
		}
		System.out.println("Total: " + sum);
	}
}