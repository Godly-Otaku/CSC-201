package HW;

public class Pencil {
	private String color;
	private String brand;
	private double unitPrice;

	public Pencil(String color, String brand, double unitPrice) {
		setBrand(brand);
		setColor(color);
		setPrice(unitPrice);
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getBrand() {
		return brand;
	}

	public String getColor() {
		return color;
	}

	public double getPrice() {
		return unitPrice;
	}

	public String toString() {
		return color + "   " + brand + "\t" + unitPrice;
	}
}
