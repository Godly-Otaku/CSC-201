package Lab18;

public class Manager extends Employee {
	private double weeklySalary;

	public Manager(String firstName, String lastName, double weeklySalary) {
		super(firstName, lastName);
		setWeeklySalary(weeklySalary);
	}

	public void setWeeklySalary(double weeklySalary) {
		this.weeklySalary = weeklySalary;
	}

	public double getWeeklySalary() {
		return weeklySalary;
	}

	public String toString() {
		return super.getFirstName() + " " + super.getLastName() + "\t$" + getWeeklySalary();
	}

	public double earnings() {
		return 0;
	}
}