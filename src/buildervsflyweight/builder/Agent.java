package buildervsflyweight.builder;

public class Agent {
	private String agentId;
	private Address workLocation;
	
	public Agent(String agentId, Address workLocation){
		this.agentId = agentId;
		this.workLocation = workLocation;
	}
	
	public String getId(){
		return agentId;
	}
}
