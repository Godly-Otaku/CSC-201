package Test2;

public class Car {
	private double speed;

	public Car(double speed) {
		if (speed > 100 || speed < 0)
			speed = 50;
		this.speed = speed;
	}

	public double getSpeed() {
		return speed;
	}

	public void accelerate() {
		if (speed < 100)
			speed += 1;
		if (speed > 100)
			speed = 100;
	}
}