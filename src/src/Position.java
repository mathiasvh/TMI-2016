package src;

/**
 * A class of positions involving a x-coordinate and a y-coordinate.
 * 
 * @invar The x-coordinate must hold a valid value. 
 * 		| isValidCoordinate(getX())
 * @invar The y-coordinate must hold a valid value. 
 * 		| isValidCoordinate(getY())
 * @author Mathias Van Herreweghe
 * 
 */
public class Position {
	
	/**
	 * Initialize new position with given position x and y.
	 * 
	 * @param	x
	 * 			The x-coordinate for this new position.
	 * @param	y
	 * 			The y-coordinate for this new position.
	 * @post 	The new x-coordinate of this new position is equal to the given
	 *       	x-coordinate. 
	 *       	| new.getX() == x
	 * @post 	The new y-coordinate of this new position is equal to the given
	 *       	y-coordinate. 
	 *       	| new.getY() == y
	 * @throws	IllegalCoordinateException(x)
	 * 			This new position can not have the given x-coordinate as its
	 * 			x-coordinate.
	 * 			| !isValidCoordinate(x)
	 * @throws	IllegalCoordinateException(y)
	 * 			This new position can not have the given y-coordinate as its
	 * 			y-coordinate.
	 * 			| !isValidCoordinate(y)
	 */
	public Position(int x, int y) throws IllegalCoordinateException {
		if (!isValidCoordinate(x))
			throw new IllegalCoordinateException(x);
		this.x = x;
		if (!isValidCoordinate(y))
			throw new IllegalCoordinateException(y);
		this.y = y;
	}
	
	/**
	 * Check whether a position can have the given coordinate as a coordinate.
	 * 
	 * @param	cor
	 * 			The coordinate to check.
	 * @return	True if and only if the given coordinate is not Not-A-Number.
	 * 			| result == !Double.isNaN(cor)
	 */
	public static boolean isValidCoordinate(int val) {
		return val >= 0;
	}
	
	/**
	 * Return the x-coordinate of this position.
	 *	The x-coordinate of a position determines what the position is on 
	 *	a x-axis.
	 */
	public double getX(){
		return this.x;
	}
	
	/**
	 * Set the x-coordinate for this position to the given x-coordinate.
	 * 
	 * @param	x
	 * 			The new x-coordinate for this position.
	 * @post	The new x-coordinate for this position is equal to the given
	 * 			x-coordinate.
	 * 			| new.getX() == x
	 * @throws	IllegalCoordinateException(x)
	 * 			This position cannot have the given x-coordinate as its x-coordinate.
	 * 			| !isValidCoordinate(x)
	 */
	public void setX(int x) throws IllegalCoordinateException{
		if (!isValidCoordinate(x))
			throw new IllegalCoordinateException(x);
		this.x = x;
	}

	/**
	 * Variable registering the x-coordinate of this position.
	 */
	private int x;
	
	/**
	 * Return the y-coordinate of this position.
	 *	The y-coordinate of a position determines where the position is on
	 *	a y-axis.
	 */
	public int getY(){
		return this.y;
	}
	
	/**
	 * Set the y-coordinate for this position to the given y-coordinate.
	 * 
	 * @param	y
	 * 			The new y-coordinate for this position.
	 * @post	The new y-coordinate for this position is equal to the given
	 * 			y-coordinate.
	 * 			| new.getY() == y
	 * @throws	IllegalCoordinateException(y)
	 * 			This position cannot have the given y-coordinate as its y-coordinate.
	 * 			| !isValidCoordinate(y)
	 */
	public void setY(int y) throws IllegalCoordinateException{
		if (!isValidCoordinate(y))
			throw new IllegalCoordinateException(y);
		this.y = y;
	}

	/**
	 * Variable registering the y-coordinate of this position.
	 */
	private int y;

	/**
	 * Calculates and returns the distance between this position and the given position.
	 * 
	 * @param	end
	 * 			The end position for which the distance will be calculated.
	 * @return	The distance between this position and the given position.
	 * 			| result == (int) Math.sqrt( Math.pow(getX() - end.getX(), 2) + 
	 * 			|				Math.pow( getY() - end.getY(), 2))
	 */
	public int getDistanceTo(Position end) {
		return (int) Math.sqrt( Math.pow(getX() - end.getX(), 2) + Math.pow( getY() - end.getY(), 2));
	}

	/**
	 * Calculates and returns the slope between this position and the given position.
	 * 
	 * @param	end
	 * 			The end position for which the slope will be calculated.
	 * @return	Zero if and only if the x-coordinate of this position is equal to the x-coordinate
	 * 			of the given position.
	 * 			| result == 0.0
	 * @return	Otherwise, the slope between this position and the given position will be returned.
	 * 			| result == Math.atan(( getY() - end.getY()) 
	 *			|				/ (getX() - end.getX()))
	 */
	public double getSlope(Position end){
		if (getX() == end.getX())
			return 0.0;
		return Math.atan(( getY() - end.getY()) 
					/ (getX() - end.getX()));
	}
	
	public boolean equals (Position other){
		return getX() == other.getX() && getY() == other.getY();
	}
}
