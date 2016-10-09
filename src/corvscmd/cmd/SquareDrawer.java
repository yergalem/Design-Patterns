package corvscmd.cmd;

public class SquareDrawer {
	
    Coordinate cordinate;
    
	public SquareDrawer() {

	}

	public Square scale( Square sqr, int scale) {

		sqr.side *= scale;
		return sqr;
	}

	public Square create(int side) {

		return new Square(side);
	}
	
	public Square move( Square sqr, Coordinate alignment ) {

		sqr.pos = alignment;
		return sqr;
	}
	
}
