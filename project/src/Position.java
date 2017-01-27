package src;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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
	public Position(double x, double y) throws IllegalCoordinateException {
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
	 * 			| result == (val >= 0)
	 */
	public static boolean isValidCoordinate(double val) {
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
	public void setX(double x) throws IllegalCoordinateException{
		if (!isValidCoordinate(x))
			throw new IllegalCoordinateException(x);
		this.x = x;
	}

	/**
	 * Variable registering the x-coordinate of this position.
	 */
	private double x;
	
	/**
	 * Return the y-coordinate of this position.
	 *	The y-coordinate of a position determines where the position is on
	 *	a y-axis.
	 */
	public double getY(){
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
	public void setY(double y) throws IllegalCoordinateException{
		if (!isValidCoordinate(y))
			throw new IllegalCoordinateException(y);
		this.y = y;
	}

	/**
	 * Variable registering the y-coordinate of this position.
	 */
	private double y;

	/**
	 * Calculates and returns the distance between this position and the given position.
	 * 
	 * @param	end
	 * 			The end position for which the distance will be calculated.
	 * @return	The distance between this position and the given position.
	 * 			| result == (double) Math.sqrt( Math.pow(getX() - end.getX(), 2) + 
	 * 			|				Math.pow( getY() - end.getY(), 2))
	 */
	public double getDistanceTo(Position end) {
		return Math.sqrt( Math.pow(getX() - end.getX(), 2) + Math.pow( getY() - end.getY(), 2));
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
	
	/**
	 * Checks whether or not this point equals the other given position.
	 * 
	 * @param	other
	 * 			The other position for which will be checked if it equals this position.
	 * @return	True if and only if both the value of this x equals that of the other x, 
	 *          and the value of this y equals that of the other y.
	 * 			| result == (getX() == other.getX() && getY() == other.getY())
	 */
	@Override
	public boolean equals (Object otherobject){
		if (otherobject == null) return false;
	    if (otherobject == this) return true;
	    if (!(otherobject instanceof Position)) return false;
		Position other = (Position) otherobject;
		return new EqualsBuilder().
	            append(x, other.x).
	            append(y, other.y).
	            isEquals();
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 31).append(x).append(y).toHashCode();
	}
}
