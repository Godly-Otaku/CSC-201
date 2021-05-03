package Lab6;

public class TossingCoinSimulation {
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		int heads = 0, tails = 0;
		for (int i = 0; i < N; i++) {
			int result = (int) (Math.random() * 2);
			if (result == 0)
				heads++;
			else
				tails++;
		}
		System.out.println("Heads: " + heads);
		System.out.println("Tails: " + tails);
	}
}