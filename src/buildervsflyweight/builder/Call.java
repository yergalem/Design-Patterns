package buildervsflyweight.builder;

import java.util.Date;

public class Call {

	private String requestId;
	private Agent agent;
	
	public void callPop(Agent agent){
		this.agent = agent;
		this.requestId = ""+(new Date()).getTime();
	}
	
	public String getRequestId() {
		return requestId;
	}

	public Agent getAgent() {
		return agent;
	}
}
