package src;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class TestCase {

	public void execute() throws IOException {

		int amount = 1000;
		int jump = amount / 100 == 0 ? 1 : amount / 100;
		double maxEdge = 0.2;
		int nbTests = 3;
		boolean checkCorrectness = false;
		String workpath = "D:\\Dropbox\\School\\Fase 2\\Sem 2\\TMI\\project\\";

		if (checkCorrectness)
			checkCorrectness(amount, maxEdge, jump, nbTests);

		XYSeriesCollection dataset = run(amount, maxEdge, jump, nbTests);

		JFreeChart timeChart = ChartFactory.createScatterPlot("Algorithm 1, 2 en 3 with a maximum edge of " + maxEdge,
				"Number of rectangles", "Time in ms", dataset, PlotOrientation.VERTICAL, true, false, false);
		File file = new File(workpath + "Experiment" + maxEdge + ".png");
		ChartUtilities.saveChartAsPNG(file, timeChart, 500, 500);
	}

	public static void checkCorrectness(int nbOfRectanglesLimit, double maxEdge, int jump, int nbTests) {

		Algorithm algo1 = new Algorithm(1);
		Algorithm algo2 = new Algorithm(2);
		Algorithm algo3 = new Algorithm(3);
		HashSet<Position> solution1 = new HashSet<Position>();
		HashSet<Position> solution2 = new HashSet<Position>();
		HashSet<Position> solution3 = new HashSet<Position>();

		for (int i = 0; i <= nbOfRectanglesLimit; i += jump) {
			System.out.println("---Number of rectangles: " + i + "---");

			for (int j = 1; j <= nbTests; j++) {
				ArrayList<Rectangle> rectangleList = Rectangle.generateRandomRectangles(i, maxEdge);
				System.out.println("-test number: " + j + "-");

				solution1.addAll(algo1.execute(rectangleList));
				solution2.addAll(algo2.execute(rectangleList));
				solution3.addAll(algo3.execute(rectangleList));

				if (!solution1.equals(solution2) || !solution2.equals(solution3) || !solution1.equals(solution3)) {
					System.out.println("1==2: " + solution1.equals(solution2));
					System.out.println("1==3: " + solution1.equals(solution3));
					System.out.println("2==3: " + solution2.equals(solution3));
					throw new AssertionError();
				}
			}
		}
	}

	public static XYSeriesCollection run(int nbOfRectanglesLimit, double maxEdge, int jump, int nbTests) {
		XYSeries serie1Time = new XYSeries("Algorithm 1"), serie2Time = new XYSeries("Algorithm 2"),
				serie3Time = new XYSeries("Algorithm 3");

		Algorithm algo1 = new Algorithm(1);
		Algorithm algo2 = new Algorithm(2);
		Algorithm algo3 = new Algorithm(3);

		for (int i = 0; i <= nbOfRectanglesLimit; i += jump) {
			System.out.println("---Number of rectangles: " + i + "---");

			long runningTime1 = 0, runningTime2 = 0, runningTime3 = 0;
			Stopwatch timer = new Stopwatch();

			for (int j = 1; j <= nbTests; j++) {
				ArrayList<Rectangle> rectangleList = Rectangle.generateRandomRectangles(i, maxEdge);
				System.out.println("-test number: " + j + "-");

				timer.start();
				algo1.execute(rectangleList);
				timer.stop();
				runningTime1 += timer.getElapsedTimeInMs();

				timer.start();
				algo2.execute(rectangleList);
				timer.stop();
				runningTime2 += timer.getElapsedTimeInMs();

				timer.start();
				algo3.execute(rectangleList);
				timer.stop();
				runningTime3 += timer.getElapsedTimeInMs();
			}

			serie1Time.add(new XYDataItem(i, runningTime1 / nbTests));
			serie2Time.add(new XYDataItem(i, runningTime2 / nbTests));
			serie3Time.add(new XYDataItem(i, runningTime3 / nbTests));
		}

		XYSeriesCollection datasetTime = new XYSeriesCollection();
		datasetTime.addSeries(serie1Time);
		datasetTime.addSeries(serie2Time);
		datasetTime.addSeries(serie3Time);

		return datasetTime;
	}

}
