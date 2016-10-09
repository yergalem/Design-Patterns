package corvscmd.cmd;
/**
 * Scales a given square by the specified scaling unit. Also, it undoes the scaling action.
 * A Client's call to execute fires the scale operation of SquarDrawer 
 * 
 * @author Yergalem
 *
 */
public class ScaleCommand implements Command {

	Square square ;
	SquareDrawer drawer = new SquareDrawer();;
	int scale;
	
	public ScaleCommand() {
	
		this.square = new Square();
	}

	public ScaleCommand( Square sqr , int scale ) {
	    this.scale = scale;  
	    this.square = sqr;
	}
	
    @Override
	public Square execute() {
		
		 return drawer.scale( square, scale);
	}

	@Override
	public Square undo() {
		square.side /= scale;
		return square;
	}

}
