package Lab18a;

public class Driver {
	public static void main(String[] args) {
		Rectangle r = new Rectangle(20, 30);
		Box b = new Box(20, 30, 50);
		System.out.println("Rectangle Dimensions: " + r.getHeight() + " " + r.getWidth());
		System.out.println("Box Dimensions: " + b.getLength() + " " + b.getWidth() + " " + b.getHeight());
		System.out.println("Box Area: " + b.area());
		System.out.println("Box Volume: " + b.volume());
	}
}
