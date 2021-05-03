package Lab21;

public class Sorting {
	public static void main(String[] args) {
		int[] bArr = { 3, 10, 7, 1 };
		int[] sArr = { 17, 4, 9, 12 };
		System.out.println(printArr(bubble(bArr)));
		System.out.println();
		System.out.println(printArr(selection(sArr)));
	}

	public static int[] bubble(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (arr[j] > arr[j + 1]) {
					// swap arr[j+1] and arr[j]
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
		return arr;
	}

	public static int[] selection(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
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
		return arr;
	}

	public static String printArr(int[] arr) {
		String output = "";
		for (int x : arr)
			output += x + " ";
		return output;
	}
}