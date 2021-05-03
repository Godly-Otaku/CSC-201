package HW;

public class WaterWell {
	public static void main(String[] args) {
		double old = Integer.parseInt(args[0]);
		double radius = (double) old / 12;
		int height = Integer.parseInt(args[1]);
		double volume = Math.PI * (radius * radius) * height;
		int gallons = (int) (volume * 7.48);
		System.out.println("Gallons available in the well: " + gallons);
	}
}