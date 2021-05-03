package Test2;

public class test {
	public static void main(String[] args) {
		int[] data = { 1, 1, 7, 1, 8, 8 };
		System.out.println(checkIDs(data));
	}

	public static int checkIDs(int[] idMapping) {
		outer: for (int i = 0; i < idMapping.length; i++) {
			for (int j = idMapping.length - 1; j >= 0; j--) {
				if (idMapping[i] == idMapping[j] && i != j)
					continue outer;
				if (j == 0 && idMapping[i] != idMapping[j])
					return idMapping[i];
			}
		}
		return idMapping[0];
	}
}
