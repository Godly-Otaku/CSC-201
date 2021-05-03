package Lab0;

public class FtoC {
	public static void main(String[] args) {
		int Fahrenheit = Integer.parseInt(args[0]);
		int Celcius = (int) ((Fahrenheit - 32) * (double) (5 / 9));
		System.out.println(Fahrenheit + " Farenheit is " + Celcius + " in Celcius.");
	}
}