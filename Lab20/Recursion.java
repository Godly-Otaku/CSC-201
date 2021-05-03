package Lab20;

public class Recursion {

	public static boolean isPalindrome(String str) {
		if (str.length() <= 1)
			return true;
		else if (str.charAt(0) == str.charAt(str.length() - 1))
			return isPalindrome(str.substring(1, str.length() - 1));
		else
			return false;
	}

	public static int multiplication(int a, int b) {
		if (b > a)
			return multiplication(b, a);
		else if (b != 0)
			return (a + multiplication(a, b - 1));
		else
			return 0;
	}
}