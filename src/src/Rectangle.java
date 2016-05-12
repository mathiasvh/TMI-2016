package src;

public class Rectangle {
	
	public Rectangle(Position lb, Position rt){
		this.leftBottom = lb;
		this.rightTop = rt;
	}
	
	private final Position leftBottom, rightTop;
}
