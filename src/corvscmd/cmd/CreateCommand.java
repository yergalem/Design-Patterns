package corvscmd.cmd;

public class CreateCommand implements Command {

	SquareDrawer drawer = new SquareDrawer();
	int side;
	
	public CreateCommand(int side) {
		this.side = side;
	}
	
	@Override
	public Square execute() {
		
		return drawer.create(side);
	}

	@Override
	public Square undo() {
		return null;
	}
    
	

}
