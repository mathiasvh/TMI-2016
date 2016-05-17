package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public final class Algorithm {
	
	public Algorithm(){
		
	}
	
	public Algorithm(int version){
		this.version = version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getVersion() {
		return this.version;
	}

	public void setNbFigures(int nbFigures) {
		this.nbFigures = nbFigures;
	}

	public int getNbFigures() {
		return this.nbFigures;
	}

	public ArrayList<Position> execute(ArrayList<Rectangle> rectangleList) throws AssertionError {
		switch (this.version) {
		case 1:
			return algorithm1(rectangleList);
		case 2:
			return algorithm2(rectangleList);
		case 3:
			return algorithm3(rectangleList);
		default:
			throw new AssertionError();
		}
	}

	private ArrayList<Position> algorithm1(ArrayList<Rectangle> rectangleList) {
		//System.out.println("Algo1 in action!");
		ArrayList<Position> intersections = new ArrayList<Position>();
		for (int i = 0; i < rectangleList.size(); i++)
			for (int j = i + 1; j < rectangleList.size(); j++)
				intersections.addAll(rectangleList.get(i).getIntersections(rectangleList.get(j)));
		return intersections;
	}

	private ArrayList<Position> algorithm2(ArrayList<Rectangle> rectangleList) {
		//System.out.println("Algo2 in action!");
		ArrayList<Unit> units = createUnits(rectangleList);
		HashSet<Rectangle> activeRecs = new HashSet<Rectangle>();
		ArrayList<Position> intersections = new ArrayList<Position>();

		for (Unit unit : units) {
			if (unit.isLeft()) {
				for (Rectangle activeRec : activeRecs)
					intersections.addAll(unit.getRectangle().getIntersections(activeRec));
				activeRecs.add(unit.getRectangle());
			} else
				activeRecs.remove(unit.getRectangle());
		}
		return intersections;
	}

	/*
	 * var queue: sorted on y-value of center point of rectangle
	 */
	private ArrayList<Position> algorithm3(ArrayList<Rectangle> rectangleList) {
		//System.out.println("Algo3 in action!");
		ArrayList<Unit> units = createUnits(rectangleList);
		ArrayList<Position> intersections = new ArrayList<Position>();
		BST<Double, Rectangle> activeRecs = new BST<Double, Rectangle>();
		BST<Double, Integer> reaches = new BST<Double, Integer>();
		double maxReach = 0D;

		for (Unit unit : units) {
			final double currentReach = unit.getRectangle().getHeight() / 2;
			if (unit.isLeft()) {
				final double lo = unit.getRectangle().getLeftBottom().getY() - maxReach;
				final double hi = unit.getRectangle().getRightTop().getY() + maxReach;
				for (double activeRecKey : activeRecs.keys(lo, hi))
					intersections.addAll(unit.getRectangle().getIntersections(activeRecs.get(activeRecKey)));

				activeRecs.put(new Double(unit.getRectangle().getCenter().getY()), unit.getRectangle());
				maxReach = Math.max(maxReach, currentReach);
				if (reaches.contains(currentReach))
					reaches.put(currentReach, reaches.get(currentReach) + 1);
				else
					reaches.put(currentReach, 1);
			} else {
				activeRecs.delete(unit.getRectangle().getCenter().getY());
				if (reaches.get(currentReach) > 1)
					reaches.put(currentReach, reaches.get(currentReach) - 1);
				else
					reaches.delete(currentReach);
				maxReach = reaches.isEmpty() ? 0D : reaches.max();
			}
		}
		return intersections;
	}

	private ArrayList<Unit> createUnits(ArrayList<Rectangle> rectangleList) {
		ArrayList<Unit> units = new ArrayList<Unit>(2 * rectangleList.size());
		final boolean left = true;
		final boolean right = false;
		for (Rectangle rectangle : rectangleList) {
			units.add(new Unit(rectangle, left));
			units.add(new Unit(rectangle, right));
		}
		Collections.sort(units);
		return units;
	}

	private int version = 0;
	private int nbFigures = 0;

}
