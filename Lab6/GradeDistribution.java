package Lab6;

public class GradeDistribution {
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		int[] grades = new int[N];

		for (int i = 0; i < grades.length; i++) {
			grades[i] = (int) (Math.random() * 100);
		}
		System.out.print("[");
		for (int i = 0; i < grades.length; i++) {
			if (i != (N - 1))
				System.out.print(grades[i] + ", ");
			else
				System.out.print(grades[i]);

		}
		System.out.print("]");
	}
}