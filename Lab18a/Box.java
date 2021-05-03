package Lab18a;

public class Box extends Rectangle {
	private int length;

	public Box(int height, int width, int length) {
		super(height, width);
		setLength(length);
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getLength() {
		return length;
	}

	public int volume() {
		return length * getHeight() * getWidth();
	}

	public int area() {
		return getWidth() * length;
	}
}
