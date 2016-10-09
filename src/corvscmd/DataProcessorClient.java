package corvscmd;
/**
 * Demonstrates the chain of responsibility from Validator to DataWasher to Reporter
 * 
 * @author Yergalem
 *
 */
public class DataProcessorClient {

	public static void main(String[] args) {
		
		DataProcessor processor = RoleBuilder.getHandler();
		
		Customer customer = new Customer();
		
		Address agentAddr = new Address("1000", "Fairfield","IOWA","52557" );
		Address customerAddr = new Address("1000", "Carson","California","52557" );
		Agent agent = new Agent("100", agentAddr);
		Customer validCustomer = new Customer("Yergalem","Kahsay",customerAddr,"+13214587866","y@gmail.com");
		
		CallRecord rec = new CallRecord();
	    
		rec.setCustomer(validCustomer);
		rec.setAgent(agent);
		
		processor.handleRequest(rec);
		
	}
	
}
