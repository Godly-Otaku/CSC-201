package Test1;

public class Order {
	public static void main(String[] args) {
		int arr[] = new int[args.length];
		for (int i = 0; i < args.length; i++) {
			arr[i] = Integer.parseInt(args[i]);
		}
		for (int i = 0; i < arr.length - 1; i++) { // Selection sorting algorithm
			int min = i;
			for (int index = i + 1; index < arr.length; index++) {
				if (arr[index] < arr[i]) {
					min = index;
					arr[min] += arr[i]; // Switching values of arr[i] and arr[min]
					arr[i] = arr[min] - arr[i];
					arr[min] = arr[min] - arr[i];
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
