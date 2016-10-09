package corvscmd.cmd;

public interface Command {

	public Square execute();
	public Square undo();
}
