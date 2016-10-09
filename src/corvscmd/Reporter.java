package corvscmd;
/**
 * Handles Sales Lead that are forwarded from Data Washer. Displays for call records with
 * marked as isASalesLead from DataWasher
 * 
 * @author Yergalem
 *
 */
public class Reporter extends DataProcessor{

	@Override
	public void handleRequest(CallRecord rec) {

		System.out.println("Sales Lead Report");
		if( rec.isASalesLead() ) {
			System.out.println( rec );
		}
		
		
		
	}

}
