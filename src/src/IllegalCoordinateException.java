package src;

/**
 * A class of exceptions signaling illegal coordinates for a certain object. Each
 * illegal coordinate exception involves the illegal coordinate.
 * 
 * @author Mathias Van Herreweghe
 */
@SuppressWarnings("serial")
public class IllegalCoordinateException extends RuntimeException {

	/**
	 * Initialize this new illegal number exception with given number
	 * 
	 * @param coordinate
	 *            The coordinate for this new illegal coordinate exception.
	 * @post The number for this new illegal number exception is equal to the
	 *       given number. | new.getNumber() == number
	 * @post The coordinate for this new illegal coordinate exception is the same
	 *       as the coordinate. | new.getCoordinate() == coordinate
	 */
	public IllegalCoordinateException(int coordinate) {
		this.coordinate = coordinate;
	}

	/**
	 * Return the coordinate of this illegal coordinate exception.
	 */
	public int getCoordinate() {
		return coordinate;
	}

	/**
	 * Variable registering the coordinate of this illegal coordinate exception.
	 */
	private final int coordinate;
}