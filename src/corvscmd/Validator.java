package corvscmd;

/**
 * Handles Call Records requests and forwards them to DataWasher 
 * Displays invalid requests whose attributes are empty
 * 
 * @author Yergalem
 *
 */
public class Validator extends DataProcessor {

	@Override
	public void handleRequest(CallRecord rec) {
		
		if( isValid( rec.getCustomer() ) ) {
			rec.setValid(true);
			successor.handleRequest(rec);
			return;
		}
		
		System.out.println("Invalid Requests");
		System.out.println( rec );
	}

	
	private boolean isValid(Customer customer) {
		if( customer.getEmail() != "" && customer.getAddress() != null
		    && customer.getPhone() != "" )
		return true;
		
	    return false;
	}

	
}
