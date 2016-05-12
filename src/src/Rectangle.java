package src;

public class Rectangle {
	
	public Rectangle(int lb, int rt){
		if (!isValidCoordinate(lb))
			throw new IllegalCoordinateException(lb);
		if (!isValidCoordinate(rt))
			throw new IllegalCoordinateException(rt);
		this.leftBottom = lb;
		this.rightTop = rt;
	}
	
	private final int leftBottom, rightTop;
	
	public static boolean isValidCoordinate(int cor) {
		return cor >= 0;
	}
}
