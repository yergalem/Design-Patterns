package bridgevsdecorator;

abstract public class Profiler {

	abstract void addTimeLen(String elt);
	abstract void removeTimeLen(String elt);
	abstract void containsTimeLen(String elt);
	abstract void sizeTimeLen();
}
