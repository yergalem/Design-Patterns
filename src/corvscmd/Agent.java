package corvscmd;

public class Agent {
	private String agentId;
	private Address workLocation;
	
	public Agent( String ID, Address addr ) {
		agentId = ID;
		workLocation = addr;
	}
}