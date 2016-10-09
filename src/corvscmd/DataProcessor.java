package corvscmd;

public abstract class DataProcessor {

	protected DataProcessor successor;
	public void setSuccessor( DataProcessor handler) {
		successor  = handler;
	}

	public abstract void handleRequest( CallRecord rec );
	
	public void processRequest(CallRecord request){
		RoleBuilder.getHandler().handleRequest(request );
	}
}
