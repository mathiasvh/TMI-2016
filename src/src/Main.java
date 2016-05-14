package src;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		boolean test = false;

		File input;
		String path;
		Algorithm algorithm = new Algorithm();
		Stopwatch timer = new Stopwatch();
		MyFileHandler fileHandler = new MyFileHandler();

		if (test) {
			path = "D:\\Dropbox\\School\\Fase 2\\Sem 2\\TMI\\project\\";
			input = new File(path + "input.txt");
		} else {
			input = fileHandler.retrieveFile();
			path = input.getParent() + "\\";
		}

		ArrayList<Rectangle> rectangles = retrieveRectangles(input, algorithm);

		timer.start();
		ArrayList<Position> intersections = algorithm.execute(rectangles);
		timer.stop();

		fileHandler.outputFile(intersections, timer.getElapsedTimeInMs(), path);
	}

	private static ArrayList<Rectangle> retrieveRectangles(File file, Algorithm algo) {
		try {
			ArrayList<Rectangle> rectangleList = new ArrayList<Rectangle>();
			Scanner reader = new Scanner(file);

			algo.setVersion(Integer.valueOf(reader.nextLine()));
			int nbRectangles = Integer.valueOf(reader.nextLine());
			algo.setNbFigures(nbRectangles);

			for (int i = 0; i < nbRectangles; i++) {
				String rectangleString = reader.nextLine();
				String[] rectangleStringSplit = rectangleString.split(" ");
				Position lb = new Position(Double.parseDouble(rectangleStringSplit[0]),
						Double.parseDouble(rectangleStringSplit[1]));
				Position rt = new Position(Double.parseDouble(rectangleStringSplit[2]),
						Double.parseDouble(rectangleStringSplit[3]));
				rectangleList.add(new Rectangle(lb, rt));
			}
			reader.close();
			return rectangleList;
		} catch (Exception e) {
			System.err.println("File is not found or does not meet expected layout !"
					+ System.getProperty("line.separator") + "Error log: " + e.toString());
			return new ArrayList<Rectangle>();
		}
	}

}
