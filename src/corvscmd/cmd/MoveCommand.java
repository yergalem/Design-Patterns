package corvscmd.cmd;
/**
 * Moves the Shape/ Square by the position specified in Coordinate(x,y) where positive x 
 * shift x units to right and negative shifts to left. And, y shifts the square y units up
 * and down if it's negative.
 * 
 * moves and undoes the displacement when required to adjust to previous position.
 * @author Yergalem
 *
 */
public class MoveCommand implements Command{

	Square square ;
	SquareDrawer drawer = new SquareDrawer();;
	Coordinate shift;
		
	public MoveCommand(Square square, Coordinate shift ) {
		super();
		this.square = square;
		this.shift = shift;
	}

	@Override
	public Square execute() {
		return drawer.move(square, shift);
	}

	@Override
	public Square undo() {
		Coordinate movedPos = square.getPos();
		movedPos.posLeft -= shift.posLeft;
		movedPos.posTop  -= shift.posTop;
		
		square.setPos(movedPos);
		
		return square;
		
	}

}
