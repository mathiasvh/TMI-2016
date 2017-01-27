package src;

public class Unit implements Comparable<Unit> {

	public Unit(Rectangle rectangle, boolean left) {
		this.rectangle = rectangle;
		this.left = left;
		this.xmarker = (left) ? rectangle.getLeftBottom().getX() : rectangle.getRightTop().getX();
	}

	public Rectangle getRectangle() {
		return this.rectangle;
	}
	
	public boolean isLeft(){
		return this.left;
	}

	public int compareTo(Unit other) {
		if (this.xmarker == other.xmarker)
			return 0;
		return (this.xmarker < other.xmarker) ? -1 : 1;
	}

	final private Rectangle rectangle;
	final boolean left;
	final double xmarker;
}
