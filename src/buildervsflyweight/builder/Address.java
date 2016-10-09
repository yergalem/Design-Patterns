package buildervsflyweight.builder;

public class Address {
	private String streetAddress;
	private String city;
	private String state;
	private String zipCode;
	
	public Address(String streetAddress, String city, String state, String zipCode){
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
	
	/* 
	 * If all fields are empty then it is invalid
	 */
	public boolean isValid(){
		if(streetAddress.isEmpty() && city.isEmpty() 
				&& state.isEmpty() && zipCode.isEmpty()){
			return true;
		}
		return false;
	}
}
