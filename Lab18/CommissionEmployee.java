package Lab18;

public class CommissionEmployee extends Employee {
	private double baseWeeklySalary;
	private double commissionRate;
	private double weeklySales;

	public CommissionEmployee(String firstName, String lastName, double baseWeeklySalary, double weeklySales,
			double commissionRate) {
		super(firstName, lastName);
		setCommissionRate(commissionRate);
		setWeeklySales(weeklySales);
		setBaseWeeklySalary(baseWeeklySalary);
	}

	public void setBaseWeeklySalary(double baseWeeklySalary) {
		this.baseWeeklySalary = baseWeeklySalary;
	}

	public void setCommissionRate(double commissionRate) {
		this.commissionRate = commissionRate;
	}

	public void setWeeklySales(double weeklySales) {
		this.weeklySales = weeklySales;
	}

	public double getBaseWeeklySalary() {
		return baseWeeklySalary;
	}

	public double getCommissionRate() {
		return commissionRate;
	}

	public double getWeeklySales() {
		return weeklySales;
	}

	public String toString() {
		double pay = baseWeeklySalary + (commissionRate * weeklySales);
		return super.getFirstName() + " " + super.getLastName() + "\t$" + pay + " (Base salary: $" + baseWeeklySalary
				+ ", sales: $" + weeklySales + ", Commission rate: " + (commissionRate * 100) + "%)";
	}

	public double earnings() {
		return 0;
	}
}