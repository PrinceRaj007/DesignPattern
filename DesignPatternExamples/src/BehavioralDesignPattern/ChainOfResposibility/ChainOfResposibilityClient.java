package BehavioralDesignPattern.ChainOfResposibility;

final class ChainOfResposibilityClient {

	public static void main(String[] args) {
		Logger console = new ConsoleLogger(Logger.INFO, null);
		Logger file = new FileLogger(Logger.DEBUG, console);
		Logger error = new ErrorLogger(Logger.ERROR, file);
		
		error.logMessage(Logger.INFO, "This is in INFO logging");
		error.logMessage(Logger.DEBUG, "This is in DEBUG logging");
		error.logMessage(Logger.ERROR, "This is in ERROR logging");
	}

}

abstract class Logger {
	public static final int INFO = 1;
	public static final int DEBUG = 2;
	public static final int ERROR = 3;

	int level;
	Logger next;

	void logMessage(int level, String message) {
		if (this.level <= level) {
			write(message);
		}
		if (next != null) {
			next.logMessage(level, message);
		}
	}

	abstract void write(String message);
}

class ConsoleLogger extends Logger {

	public ConsoleLogger(int level, Logger next) {
		this.level = level;
		this.next = next;
	}

	@Override
	void write(String message) {
		System.out.println("Console Log: " + message);
	}

}

class FileLogger extends Logger {

	public FileLogger(int level, Logger next) {
		this.level = level;
		this.next = next;
	}

	@Override
	void write(String message) {
		System.out.println("File Log: " + message);
	}

}

class ErrorLogger extends Logger {

	public ErrorLogger(int level, Logger next) {
		this.level = level;
		this.next = next;
	}

	@Override
	void write(String message) {
		System.out.println("Error Log: " + message);
	}

}