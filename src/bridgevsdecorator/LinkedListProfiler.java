package bridgevsdecorator;

import java.util.LinkedList;

public class LinkedListProfiler extends ListDecorator {

	public LinkedListProfiler(Profiler profiler) {
		super(profiler);
		list = new LinkedList<>();
		System.out.println("\tLinkedList");
	}

	@Override
	void addTimeLen(String elt) {
		
		super.addTimeLen(elt);
		long start = System.currentTimeMillis();
		list.add(elt);
		
		System.out.println(System.currentTimeMillis() - start +" milliseconds");
		
	}
	@Override
	void removeTimeLen(String elt) {
		super.removeTimeLen(elt);
		
		long start = System.currentTimeMillis();
		list.remove(elt);
		
		System.out.println( System.currentTimeMillis() - start +" milliseconds");
	}
	@Override
	void containsTimeLen(String elt) {
		super.containsTimeLen(elt);
		
		long start = System.currentTimeMillis();
		list.contains(elt);
		
		System.out.println( System.currentTimeMillis() - start +" milliseconds");
	}
	@Override
	void sizeTimeLen() {
		super.sizeTimeLen();
		
		long start = System.currentTimeMillis();
		list.size();
		
		System.out.println( System.currentTimeMillis() - start +" milliseconds");
	}
}
