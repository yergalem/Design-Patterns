package factory;

/**
 * Factory method that creates both console and file trace instances based on
 * literal passed to it.
 * 
 * @author Yergalem
 *
 */
public class LogTraceFactory implements TraceFactory {

	private static LogTraceFactory factory = new LogTraceFactory();

	public static LogTraceFactory getFactory() {
		return factory;
	}

	public static void setFactory(LogTraceFactory factory) {
		LogTraceFactory.factory = factory;
	}

	@Override
	public Trace createTrace(String name) {
		Trace trace = null;

		if (name.equals("file")) {
			trace = new FileTrace();
		} else if (name.equals("console")) {
			trace = new ConsoleTrace();
		}

		return trace;
	}

}
