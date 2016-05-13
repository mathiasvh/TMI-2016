package src;

public class Rectangle {

	public Rectangle(Position lb, Position rt) {
		this.leftBottom = lb;
		this.rightTop = rt;
	}

	public double getWidth() {
		return this.rightTop.getX() - this.leftBottom.getX();
	}

	public double getHeight() {
		return this.rightTop.getY() - this.leftBottom.getY();
	}
	
	/* 
	 * Checks if this rectangle overlaps the other given rectangle.
	 */
	public boolean overlaps (Rectangle other){
		return this.leftBottom.getX() < other.leftBottom.getX() + other.getWidth() && 
				this.leftBottom.getX() + this.getWidth() > other.leftBottom.getX() && 
				this.leftBottom.getY() < other.leftBottom.getY() + other.getHeight() && 
				this.leftBottom.getY() + this.getHeight() > other.leftBottom.getY();
	}	

	private final Position leftBottom, rightTop;
}
