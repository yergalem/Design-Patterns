package corvscmd.cmd;

public class Coordinate {
    int posTop;
    int posLeft;
    
    public Coordinate() {
	}

	public Coordinate(int posTop, int posLeft) {
		super();
		this.posTop = posTop;
		this.posLeft = posLeft;
	}
	
	public Coordinate(int horizontal) {
		this.posLeft = horizontal;  // positive : right  negative: left shift
	}
    
    
}
