package bridgevsdecorator;

public class BasicProfiler extends Profiler {

	public BasicProfiler() {
		System.out.print("\t\t");
	}
	@Override
	void addTimeLen(String elt) {
		System.out.print("boolean add(E e) \t\t");
	}

	@Override
	void removeTimeLen(String elt) {
		System.out.print("boolean remove(Object o) \t");
	}

	@Override
	void containsTimeLen(String elt) {
		System.out.print("boolean contains(Object o) \t");
	}

	@Override
	void sizeTimeLen() {
		System.out.print("int size() \t\t\t");
	}

	

}
