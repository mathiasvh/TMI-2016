package src;

import java.util.ArrayList;

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

	// Checks if this rectangle overlaps the other given rectangle.
	public boolean overlaps(Rectangle other) {
		return this.leftBottom.getX() < other.leftBottom.getX() + other.getWidth()
				&& this.leftBottom.getX() + this.getWidth() > other.leftBottom.getX()
				&& this.leftBottom.getY() < other.leftBottom.getY() + other.getHeight()
				&& this.leftBottom.getY() + this.getHeight() > other.leftBottom.getY();
	}

	/**
	 * Computes the intersection of this <code>Rectangle</code> with the
	 * specified <code>Rectangle</code>. Returns a new <code>Rectangle</code>
	 * that represents the intersection of the two rectangles. If the two
	 * rectangles do not intersect, the result will be an empty rectangle.
	 *
	 * @param r
	 *            the specified <code>Rectangle</code>
	 * @return the largest <code>Rectangle</code> contained in both the
	 *         specified <code>Rectangle</code> and in this
	 *         <code>Rectangle</code>; or if the rectangles do not intersect, an
	 *         empty rectangle.
	 */
	public ArrayList<Position> getIntersections(Rectangle other) {
		if (!this.overlaps(other))
			return new ArrayList<Position>();
		
		double lb1x = this.leftBottom.getX();
		double lb1y = this.leftBottom.getY();
		double rt1x = this.rightTop.getX();
		double rt1y = this.rightTop.getY();

		double lb2x = other.leftBottom.getX();
		double lb2y = other.leftBottom.getY();
		double rt2x = other.rightTop.getX();
		double rt2y = other.rightTop.getY();

		double lb_x, lb_y, rt_x, rt_y;

		lb_x = Math.max(lb1x, lb2x);
		rt_x = Math.min(rt1x, rt2x);
		lb_y = Math.max(lb1y, lb2y);
		rt_y = Math.min(rt1y, rt2y);

		ArrayList<Position> possibleIntersections = new ArrayList<Position>();
		ArrayList<Position> validIntersections = new ArrayList<Position>();
		possibleIntersections.add(new Position(lb_x, lb_y)); // left bottom
		possibleIntersections.add(new Position(lb_x, rt_y)); // left top
		possibleIntersections.add(new Position(rt_x, lb_y)); // right bottom
		possibleIntersections.add(new Position(rt_x, rt_y)); // right top

		for (Position pos : possibleIntersections) {
			boolean isIntersectionWithThis = (pos.getX() == lb1x) || (pos.getX() == rt1x) || (pos.getY() == lb1y)
					|| (pos.getY() == rt1y);
			boolean isIntersectionWithOther = (pos.getX() == lb2x) || (pos.getX() == rt2x) || (pos.getY() == lb2y)
					|| (pos.getY() == rt2y);

			boolean intersectsOnIdenticalX = ((pos.getX() == lb1x) && (pos.getX() == lb2x))
					|| ((pos.getX() == rt1x) && (pos.getX() == rt2x));
			boolean intersectsOnIdenticalY = ((pos.getY() == lb1y) && (pos.getY() == lb2y))
					|| ((pos.getY() == rt1y) && (pos.getY() == rt2y));

			boolean isIntersectionWithBoth = isIntersectionWithThis && isIntersectionWithOther;
			boolean intersectsOnIdenticalAxis = intersectsOnIdenticalX || intersectsOnIdenticalY;
			boolean isValidIntersect = isIntersectionWithBoth && !intersectsOnIdenticalAxis;

			if (isValidIntersect) {
				validIntersections.add(pos);
			}
		}

		return validIntersections;
	}

	private final Position leftBottom, rightTop;
}
