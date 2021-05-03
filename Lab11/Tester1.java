package Lab11;

public class Tester1 {
	public static void main(String[] args) {
		Student s1 = new Student("Blake", "Smith", 3.2);
		Student s2 = new Student("John", "Doe", 4.5);
		Student s3 = new Student("Heather", "White", 2.8);
		double s1GPA = s1.getGPA();
		double s2GPA = s2.getGPA();
		double s3GPA = s3.getGPA();
		double avgGPA = (s1GPA + s2GPA + s3GPA) / 3;
		s1.display();
		s2.display();
		s3.display();
		System.out.println("-----------");
		System.out.printf("Average GPA: %.2f", avgGPA);
	}
}