package bridgevsdecorator;

public class ProfilerDemo {

	public static void main(String[] args) {
		
		Profiler profiler = new LinkedListProfiler( new ArrayListProfiler(new BasicProfiler()));
		
		profiler.addTimeLen("yergalem");
		profiler.removeTimeLen("yergalem");
		profiler.containsTimeLen("yergalem");
		profiler.sizeTimeLen();
	}
}
