package Lab18a;

public class Rectangle {
	private int height;
	private int width;

	public Rectangle(int height, int width) {
		setHeight(height);
		setWidth(width);
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}
}
