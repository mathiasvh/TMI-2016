package src;

import java.util.ArrayList;

public final class Algorithms {
	private Algorithms(){
		throw new AssertionError();
	}
	
	public static void setVersion(int version){
		ALGO_VERSION = version;
	}
	
	public void execute(ArrayList<Rectangle> rectangleList) throws AssertionError{
		if (ALGO_VERSION == 1)
			algorithm1(rectangleList);
		if (ALGO_VERSION == 2)
			algorithm2(rectangleList);
		if (ALGO_VERSION == 3)
			algorithm3(rectangleList);
		if (ALGO_VERSION == 0)
			throw new AssertionError();
	}
	
	private static void algorithm3(ArrayList<Rectangle> rectangleList) {
		// TODO Auto-generated method stub	
	}

	private static void algorithm2(ArrayList<Rectangle> rectangleList) {
		// TODO Auto-generated method stub
	}

	private static void algorithm1(ArrayList<Rectangle> rectangleList) {
		// TODO Auto-generated method stub
	}

	private static int ALGO_VERSION = 0;

}
