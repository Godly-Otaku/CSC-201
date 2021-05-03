package HW;

public class Car {
	private int year;
	private String make;
	private double speed;

	public Car(int year, String make, double speed) {
		this.year = year;
		this.make = make;
		this.speed = speed;
	}

	public int getYear() {
		return year;
	}

	public String getMake() {
		return make;
	}

	public double getSpeed() {
		return speed;
	}

	public void accelerate() {
		speed += 1;
	}
}