package corvscmd;

/**
 * Handles Valid Call Records and forwards after analysis to Reporter. 
 * Displays discarded requests that are marked as invalid by Validator.
 * 
 * @author Yergalem
 *
 */
public class DataWasher extends DataProcessor {

	@Override
	public void handleRequest(CallRecord rec) {


		if( rec.isValid()  ) {
			rec.setASalesLead(true);
			successor.handleRequest(rec);
			return;
		}
		System.out.println("Discarded");
		System.out.println( rec );
		
	}

}
