package Lab18;

public abstract class Employee {
	// we will talk about abstract mehtod and class after midterm.
	// However, you may want to study this topic (zybook) in advance and try to
	// complete this assignment.

	private String firstName;
	private String lastName;
	private static int employeeID = 100;

	public Employee(String firstName, String lastName) {
		setFirstName(firstName);
		setLastName(lastName);
		employeeID++;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getEmplyeeID() {
		return employeeID;
	}

	public String toString() {
		return String.format("%20s%20s", firstName, lastName);
	}

	public abstract double earnings();
}