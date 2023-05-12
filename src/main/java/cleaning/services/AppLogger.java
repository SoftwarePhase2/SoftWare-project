package cleaning.services;

import java.util.logging.*;

public class AppLogger {
	
	private AppLogger() {
	    throw new IllegalStateException("Utility class");
	}
	
	
	public static void setLevel(Logger logs)
	{
		setlevelLogger(logs);
	}
	private static void setlevelLogger(Logger logs) {
		logs.setLevel(Level.INFO);
	}

}
