package buildervsflyweight.builder;

//Product class
public class Request {

	private String reqId;
	private Customer requester;
	private Agent agent;
	private String reqContent;
	private String respContent;
	private boolean isAnswered;
	private boolean isSaleLead;
	private boolean needCallBack;
	
	public Request(String reqId, Agent agent){
		this.reqId = reqId;
		this.agent = agent;
	}
	
	public void save(){
		
	}
	
	public Agent getAgent(){
		return agent;
	}
	
	public String getReqId() {
		return reqId;
	}

	public Customer getRequester() {
		return requester;
	}

	public void setRequester(Customer requester) {
		this.requester = requester;
	}

	public String getReqContent() {
		return reqContent;
	}

	public void setReqContent(String reqContent) {
		this.reqContent = reqContent;
	}

	public String getRespContent() {
		return respContent;
	}

	public void setRespContent(String respContent) {
		this.respContent = respContent;
	}

	public boolean isAnswered() {
		return isAnswered;
	}

	public void setAnswered(boolean isAnswered) {
		this.isAnswered = isAnswered;
	}

	public boolean isSaleLead() {
		return isSaleLead;
	}

	public void setSaleLead(boolean isSaleLead) {
		this.isSaleLead = isSaleLead;
	}

	public boolean isNeedCallBack() {
		return needCallBack;
	}

	public void setNeedCallBack(boolean needCallBack) {
		this.needCallBack = needCallBack;
	}

}
