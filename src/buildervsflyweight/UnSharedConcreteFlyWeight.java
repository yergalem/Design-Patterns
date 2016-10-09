package buildervsflyweight;
/**
 * Stores both intrinsic and extrinsic states
 * 
 * @author Yergalem
 *
 */
public class UnSharedConcreteFlyWeight implements FlyWeight{

	private String firstName;
	private String lastName;
	private int customerId;
	private Address residenceAddress;
	private HealthProfile profile;
	private Circle location;
	
	private static int counter = 0;
	
	public UnSharedConcreteFlyWeight(Circle location,String firstName, String lastName,
			int customerId, Address residenceAddress, HealthProfile profile) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.customerId = customerId;
		this.residenceAddress = residenceAddress;
		this.profile = profile;
		this.location = location;
		
		counter++;
	}


	@Override
	public int countAttendants(Customer customer) {
		
		return counter;
	}
	
	
	
}
