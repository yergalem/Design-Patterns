package buildervsflyweight.builder;

import java.util.List;


public interface IRequestBuilder {
	public void initRequest(Agent agent);
	public boolean loadUserProfile(String phone, List<Customer> customers);
	public void createCustomer(String name,String phone);
	public void createRequestContent(String requestContent);
	public void createReponseContent(String responseContent);
	public void saveRequest(boolean isAnswered, boolean needCallBack);
	
}
