package buildervsflyweight.builder;

import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args){
		Customer cust1 = new Customer("Tarekegn Sisay", "614 546 5775");
		Customer cust2 = new Customer("ALex Abreham", "762 876 3486");
		List<Customer> customers = Arrays.asList(cust1, cust2);
		Address address = new Address("1000 North 4th Street", "Fairfield", "Iowa", "52557");
		
		Agent agent = new Agent("1", address);
		
		RequestDirector director = new RequestDirector();
		director.initRequest(agent);
		director.buildRequest(customers, "614 546 5775", "Tarekegn Sisay", "request information 1", "response information 1");
		director.saveRequest(true, false);
		
		director.initRequest(agent);
		director.buildRequest(customers, "762 876 3486", "ALex Abreham", "request information 2", "response information 2");
		director.saveRequest(true, false);
		
	}
}
 