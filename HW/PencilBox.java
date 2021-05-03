package HW;

public class PencilBox {
	private Pencil type1;
	private Pencil type2;
	private int qty1;
	private int qty2;

	public PencilBox(Pencil type1, Pencil type2, int qty1, int qty2) {
		setQty1(qty1);
		setQty2(qty2);
		if (qty1 + qty2 > 10) {
			qty1 = 5;
			qty2 = 5;
		}
		setType1(type1);
		setType2(type2);
	}

	public void setQty1(int qty1) {
		this.qty1 = qty1;
	}

	public void setQty2(int qty2) {
		this.qty2 = qty2;
	}

	public void setType1(Pencil type1) {
		this.type1 = type1;
	}

	public void setType2(Pencil type2) {
		this.type2 = type2;
	}

	public int getQty1() {
		return qty1;
	}

	public int getQty2() {
		return qty2;
	}

	public Pencil getType1() {
		return type1;
	}

	public Pencil getType2() {
		return type2;
	}

	public double grandTotal() {
		double value = 0.0;
		value += type1.getPrice() * qty1;
		value += type2.getPrice() * qty2;
		return value;
	}

	public String toString() {
		String output = "";
		output += String.format("%s%10s%10.2f%n", type1.getColor(), type1.getBrand(), (type1.getPrice() * qty1));
		output += String.format("%s%10s%10.2f%n", type2.getColor(), type2.getBrand(), (type2.getPrice() * qty2));
		return output;
	}
}