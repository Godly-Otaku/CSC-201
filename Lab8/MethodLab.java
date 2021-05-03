package Lab8;

public class MethodLab {
	public static void main(String[] args) {
		int[] random = new int[30];
		for (int i = 0; i < random.length; i++) {
			random[i] = (int) (Math.random() * 51) + 50;
		}
		System.out.println("Max number: " + max(random));
		System.out.println("Range: " + range(random));
		System.out.println("Numbers above benchmark: " + aboveBenchmarck(80, random));
		System.out.print("[");
		for (int i = 0; i < random.length; i++) {
			if (i != (30 - 1))
				System.out.print(random[i] + ", ");
			else
				System.out.print(random[i]);

		}
		System.out.print("]");
	}

	public static int max(int[] arr) {
		int maxNum = arr[0];
		for (int x : arr) {
			if (x > maxNum)
				maxNum = x;
		}
		return maxNum;
	}

	public static int range(int[] arr) {
		int maxNum = arr[0];
		int minNum = arr[0];
		for (int x : arr) {
			if (x > maxNum)
				maxNum = x;
			if (x < minNum)
				minNum = x;
		}
		return maxNum - minNum;
	}

	public static int aboveBenchmarck(int benchmark, int[] arr) {
		int sum = 0;
		for (int x : arr) {
			if (x >= benchmark)
				sum++;
		}
		return sum;
	}
}
