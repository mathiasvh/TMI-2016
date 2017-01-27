package src;

import java.util.concurrent.TimeUnit;

public class Stopwatch {

	private long startTime = 0;
	private long stopTime = 0;
	private boolean running = false;

	public void start() {
		this.startTime = System.nanoTime();
		this.running = true;
	}

	public void stop() {
		this.stopTime = System.nanoTime();
		this.running = false;
	}

	// elapsed time in milliseconds
	public long getElapsedTimeInMs() {
		long elapsed;
		if (running)
			elapsed = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);
		else
			elapsed = TimeUnit.NANOSECONDS.toMillis(stopTime - startTime);
		return elapsed;
	}

	// elapsed time in seconds
	public long getElapsedTimeSecs() {
		long elapsed;
		if (running)
			elapsed = TimeUnit.NANOSECONDS.toSeconds(System.nanoTime() - startTime);
		else
			elapsed = TimeUnit.NANOSECONDS.toSeconds(stopTime - startTime);
		return elapsed;
	}
}
