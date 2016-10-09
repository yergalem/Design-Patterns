package bridgevsdecorator;

import java.util.ArrayList;

public class ArrayListProfiler extends ListDecorator {

	public ArrayListProfiler(Profiler profiler) {
		super(profiler);
		list = new ArrayList<>();
		
		System.out.print("\t\tArrayList");
	}

	@Override
	void addTimeLen(String elt) {
		super.addTimeLen(elt);
		
		long start = System.currentTimeMillis();
		list.add(elt);
		
		System.out.print( System.currentTimeMillis() - start +" milliseconds \t");
		
	}
	@Override
	void removeTimeLen(String elt) {
		super.removeTimeLen(elt);
		
		long start = System.currentTimeMillis();
		list.remove(elt);
		
		System.out.print( System.currentTimeMillis() - start +" milliseconds\t");
		
	}
	@Override
	void containsTimeLen(String elt) {
		super.containsTimeLen(elt);
		
		long start = System.currentTimeMillis();
		list.contains(elt);
		
		System.out.print( System.currentTimeMillis() - start +" milliseconds\t");
	}
	@Override
	void sizeTimeLen() {
		super.sizeTimeLen();
		
		long start = System.currentTimeMillis();
		list.size();
		
		System.out.print( System.currentTimeMillis() - start +" milliseconds\t");
	}
	

}
