package HW;

public class Encrypted {

	public static String encoding(String voiceData) {
		String finalText = "";
		boolean moreLines = true;
		for (int i = 0, j = 4; moreLines; i += 5, j += 5) {
			String temp = "";
			try {
				temp = voiceData.substring(i, j);
			} catch (Exception e) {
				moreLines = false;
			}
			if (temp.length() != 4) {
				moreLines = false;
				break;
			}
			int d1 = Integer.parseInt(temp.substring(0, 1)); // because the 1st digit might be 0
			int num = Integer.parseInt(temp);
			int d2 = (num / 100) % 10;
			int d3 = (num % 100) / 10;
			int d4 = num % 10;

			d1 = (d1 + 5) % 10;
			d2 = (d2 + 5) % 10;
			d3 = (d3 + 5) % 10;
			d4 = (d4 + 5) % 10;
			finalText += "" + d4 + d3 + d2 + d1 + "\n";
		}
		return finalText;
	}
}
