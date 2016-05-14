package src;

import java.util.ArrayList;

public final class Algorithm {
	
	public void setVersion(int version){
		this.version = version;
	}
	
	public int getVersion(){
		return this.version;
	}
	
	public void setNbFigures(int nbFigures){
		this.nbFigures = nbFigures;
	}
	
	public int getNbFigures(){
		return this.nbFigures;
	}
	
	public ArrayList<Position> execute(ArrayList<Rectangle> rectangleList) throws AssertionError{
		switch(this.version){
		case 1:	 return algorithm1(rectangleList);
		case 2:	 return algorithm2(rectangleList);
		case 3:  return algorithm3(rectangleList);
		default: throw new AssertionError();
		}				
	}
	
	private ArrayList<Position> algorithm3(ArrayList<Rectangle> rectangleList) {
		return null;
		// TODO Auto-generated method stub	
	}

	private ArrayList<Position> algorithm2(ArrayList<Rectangle> rectangleList) {
		return null;
		// TODO Auto-generated method stub
	}

	private ArrayList<Position> algorithm1(ArrayList<Rectangle> rectangleList) {
		return null;
		// TODO Auto-generated method stub
	}

	private int version = 0;
	private int nbFigures = 0;

}
