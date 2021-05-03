package HW;

public class SchoolBag {
	public static void main(String[] args) {
		Pencil p1 = new Pencil("brown", "BIC", .90);
		Pencil p2 = new Pencil("black", "CIS201", .80);
		PencilBox pBox = new PencilBox(p1, p2, 5, 5);
		System.out.printf("Color%10s%10s%n", "Brand", "Total");
		System.out.printf("-----%10s%10s%n", "-----", "-----");
		System.out.println(pBox.toString());
		System.out.printf("-------------------------%n");
		System.out.printf("%20s Total: $%.2f", "Grand", pBox.grandTotal());
	}
}