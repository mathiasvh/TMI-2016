package src;

import java.io.IOException;
import java.util.ArrayList;

public class Test {
	
	public static void main(String[] args) {
		Rectangle one = new Rectangle(new Position(0.1,0.1), new Position(0.5,0.5));
		Rectangle two = new Rectangle(new Position(0.2,0.2), new Position(0.7,0.7));
		
		ArrayList<Position> intersections = one.getIntersections(two);
		
		for (Position intersect : intersections){
			System.out.println("x: " + intersect.getX() + " y: " + intersect.getY());
		}
	}

}
