package Lab0;

public class CtoF {
	public static void main(String[] args) {
		int Celcuis = Integer.parseInt(args[0]);
		int Fahrenheit = (int) (Celcuis * (double) (9 / 5)) + 32;
		System.out.println(Celcuis + " Celius is " + Fahrenheit + " in Fahrenheit.");
	}
}
