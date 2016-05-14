package src;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class Main {

	public static void main(String[] args) {

		// File input = retrieveFile();
		File input = new File("D:\\Dropbox\\School\\Fase 2\\Sem 2\\TMI\\project\\input.txt");
		
		ArrayList<Rectangle> rectangles = retrieveRectangles(input);
		ArrayList<Position> intersections = Algorithms.execute(rectangles);

	}

	private static File retrieveFile() {
		JFileChooser fileChooser = new JFileChooser(System.getProperty("user.home"));
		int result = fileChooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			System.out.println("Selected file: " + selectedFile.getAbsolutePath());
			return selectedFile;
		} else
			return null;
	}

	private static ArrayList<Rectangle> retrieveRectangles(File file) {
		try {
			ArrayList<Rectangle> rectangleList = new ArrayList<Rectangle>();
			Scanner reader = new Scanner(file);

			int nbRectangles = Integer.valueOf(reader.nextLine());
			Algorithms.setNbFigures(nbRectangles);
			Algorithms.setVersion(Integer.valueOf(reader.nextLine()));
			for (int i = 0; i < nbRectangles; i++) {
				String rectangleString = reader.nextLine();
				String[] rectangleStringSplit = rectangleString.split(" ");
				Position lb = new Position(Double.parseDouble(rectangleStringSplit[0]),
						Double.parseDouble(rectangleStringSplit[1]));
				Position rt = new Position(Double.parseDouble(rectangleStringSplit[2]),
						Double.parseDouble(rectangleStringSplit[3]));
				rectangleList.add(new Rectangle(lb, rt));
			}
			return rectangleList;
		} catch (Exception e) {
			System.err.println("File not found!\n Error log: " + e.toString());
			return new ArrayList<Rectangle>();
		}
	}

}
