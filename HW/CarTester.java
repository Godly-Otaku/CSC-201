package HW;

public class CarTester {
	public static void main(String[] args) {
		Car vehicle = new Car(2010, "Porche", 25);
		vehicle.accelerate();
		vehicle.accelerate();
		System.out.println("Current speed: " + vehicle.getSpeed() + " mph");
		for (int i = 0; i < 1000; i++)
			vehicle.accelerate();
		System.out.println("Current speed: " + vehicle.getSpeed() + " mph");
	}
}
