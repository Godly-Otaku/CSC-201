public class test {

	public static int range(int[] array) {
		int min = array[0];
		int max = array[0];

		for (int i = 1; i < array.length; i++) {
			min = Math.min(min, array[i]);
			max = Math.max(max, array[i]);
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max)
				max = array[i];
			if (array[i] < min)
				min = array[i];
		}

		return max - min + 1;
	}

	public void add(int hours, int minutes) {
		if (hours < 0)
			hours = 0;
		if (minutes < 0)
			minutes = 0;
		hours += (minutes / 60);
		minutes %= 60;
		this.hours += hours;
		this.minutes += minutes;
	}
}