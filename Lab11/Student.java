package Lab11;

public class Student {
	private String fName;
	private String lName;
	private double gpa;

	public Student() {
		fName = "";
		lName = "";
		gpa = 3.0;
	}

	public Student(String first, String last, double grade) {
		setFirstName(first);
		setLastName(last);
		setGPA(grade);
	}

	public void setFirstName(String name) {
		if (name.length() > 25)
			fName = name.substring(0, 25);
		else
			fName = name;
	}

	public void setLastName(String name) {
		if (name.length() > 25)
			lName = name.substring(0, 25);
		else
			lName = name;
	}

	public void setGPA(double grade) {
		if (grade > 4.0)
			gpa = 4.0;
		else if (grade < 0.0)
			gpa = 0.0;
		else
			gpa = grade;
	}

	public String getFirstName() {
		return fName;
	}

	public String getLastName() {
		return lName;
	}

	public double getGPA() {
		return gpa;
	}

	public void display() {
		System.out.println(fName + "\t" + lName + "\t|\t" + gpa);
	}
}
