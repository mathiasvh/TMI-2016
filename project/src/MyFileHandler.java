package src;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JFileChooser;

public class MyFileHandler {

	public File retrieveFile() {
		JFileChooser fileChooser = new JFileChooser(System.getProperty("user.home"));
		int result = fileChooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			return selectedFile;
		} else
			return null;
	}

	public void outputFile(ArrayList<Position> intersections, long elapsedTimeMs, String path) throws IOException {

		File output = new File(path + "uitvoerrechthoeken.txt");
		PrintWriter writer = new PrintWriter(output);
		// output.createNewFile();

		if (intersections == null) {
			writer.write("No intersections were found." + System.getProperty("line.separator")
					+ "Execution time in ms: " + elapsedTimeMs + "");
			writer.close();
			return;
		} else {
			for (Position intersect : intersections)
				writer.println(intersect.getX() + " " + intersect.getY());
			writer.println();
			writer.write("Execution time in ms: " + elapsedTimeMs + "");
			writer.close();
		}

	}
}
