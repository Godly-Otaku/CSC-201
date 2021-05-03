package Lab18;

public class HourlyWorker extends Employee {
	private double hoursWorked;
	private double wage;

	public HourlyWorker(String firstName, String lastName, double wage, double hoursWorked) {
		super(firstName, lastName);
		setHoursWorked(hoursWorked);
		setWage(wage);
	}

	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}

	public double getHoursWorked() {
		return hoursWorked;
	}

	public double getWage() {
		return wage;
	}

	public String toString() {
		double pay = hoursWorked * wage;
		if (hoursWorked <= 40)
			return super.getFirstName() + " " + super.getLastName() + "\t$" + pay + " (Hourly wage: $" + wage
					+ ", hours worked: " + hoursWorked + ")";
		else {
			for (int i = (int) hoursWorked - 40; i > 0; i--)
				pay += (wage * 1.5);
			return super.getFirstName() + " " + super.getLastName() + "\t$" + pay + " (Hourly wage: $" + wage
					+ ", hours worked: " + hoursWorked + ")";
		}
	}

	public double earnings() {
		return 0;
	}
}
