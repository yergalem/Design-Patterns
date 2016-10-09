package visit;

public interface Component {
	public Side getSide();
	public void accept(NodeVisitor visitor);
}


