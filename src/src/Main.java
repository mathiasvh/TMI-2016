package src;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		/*
		 * choice == 1 -> user can choose the input file. 
		 * choice == 2 -> test the basic test file. 
		 * choice == 3 -> test and plot randomly generated rectangles.
		 */
		int choice = 1;

		if (choice == 1)
			executeUserDefinedFile();
		else if (choice == 2)
			executeTestFile();
		else if (choice == 3)
			executeTestCase();
		else
			throw new AssertionError();
		System.out.println("done.");
	}

	private static void executeTestCase() throws IOException {
		TestCase testCase = new TestCase();
		testCase.execute();
	}

	private static void executeUserDefinedFile() throws IOException {

		File input;
		String workpath;
		Algorithm algorithm = new Algorithm();
		Stopwatch timer = new Stopwatch();
		MyFileHandler fileHandler = new MyFileHandler();

		input = fileHandler.retrieveFile();
		workpath = input.getParent() + "\\";

		ArrayList<Rectangle> rectangles = retrieveRectangles(input, algorithm);

		timer.start();
		ArrayList<Position> intersections = algorithm.execute(rectangles);
		timer.stop();

		fileHandler.outputFile(intersections, timer.getElapsedTimeInMs(), workpath);
	}

	private static void executeTestFile() throws IOException {

		File input;
		String workpath;
		Algorithm algorithm = new Algorithm();

		Stopwatch timer = new Stopwatch();
		MyFileHandler fileHandler = new MyFileHandler();

		workpath = "D:\\Dropbox\\School\\Fase 2\\Sem 2\\TMI\\project\\";
		input = new File(workpath + "invoerrechthoeken.txt");

		ArrayList<Rectangle> rectangles = retrieveRectangles(input, algorithm);

		timer.start();
		ArrayList<Position> intersections = algorithm.execute(rectangles);
		timer.stop();

		fileHandler.outputFile(intersections, timer.getElapsedTimeInMs(), workpath);
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
