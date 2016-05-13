package src;

import java.util.ArrayList;

public final class Algorithms {
	private Algorithms(){
		throw new AssertionError();
	}
	
	public static void setVersion(int version){
		ALGO_VERSION = version;
	}
	
	public static void setNbFigures(int nbFigures){
		NB_FIGURES = nbFigures;
	}
	
	public ArrayList<Position> execute(ArrayList<Rectangle> rectangleList) throws AssertionError{
		
		if (ALGO_VERSION == 1)
			return algorithm1(rectangleList);
		if (ALGO_VERSION == 2)
			return algorithm2(rectangleList);
		if (ALGO_VERSION == 3)
			return algorithm3(rectangleList);
		else
			throw new AssertionError();			
	}
	
	private static ArrayList<Position> algorithm3(ArrayList<Rectangle> rectangleList) {
		return null;
		// TODO Auto-generated method stub	
	}

	private static ArrayList<Position> algorithm2(ArrayList<Rectangle> rectangleList) {
		return null;
		// TODO Auto-generated method stub
	}

	private static ArrayList<Position> algorithm1(ArrayList<Rectangle> rectangleList) {
		return null;
		// TODO Auto-generated method stub
	}

	private static int ALGO_VERSION = 0;
	private static int NB_FIGURES = 0;

}
