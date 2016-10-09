package bridgevsdecorator;

import java.util.List;

public class ListDecorator extends Profiler {
   
	List<String> list;
	
	Profiler profiler;
	public ListDecorator(Profiler profiler) {
		this.profiler = profiler;
	}
	
	@Override
	void addTimeLen(String elt) {
		profiler.addTimeLen(elt);
	}
	@Override
	void removeTimeLen(String elt) {
		profiler.removeTimeLen(elt);
	}
	@Override
	void containsTimeLen(String elt) {
		profiler.containsTimeLen(elt);
	}
	@Override
	void sizeTimeLen() {
		profiler.sizeTimeLen();
	}
	

}
