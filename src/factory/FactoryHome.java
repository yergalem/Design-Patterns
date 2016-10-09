package factory;

public class FactoryHome {

	public static void main(String[] args) {
		
		if( args.length == 0 ) {
			System.out.println("Pass initial name you want");
			System.exit(-1);
		}
		
		TraceFactory factory = LogTraceFactory.getFactory();
		Trace trace = null;
		trace = factory.createTrace("file");
//		System.out.println( trace.getClass().getSimpleName());
//		Trace trc = new FileTrace();
//		System.out.println( trc.getClass().getSimpleName());
		if( args[0].equals("trace.log") )
			trace = factory.createTrace("file");
		else if(args[0].equals("console"))
			trace = factory.createTrace("console");
		
		trace.debug("Debug Message");
		trace.error("Error message");
		
	}
}
