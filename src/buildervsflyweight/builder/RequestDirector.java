package buildervsflyweight.builder;

import java.util.List;

public class RequestDirector {
	private RequestBuilder requestBuilder; // must be object of interface IRequestBuilder
	
	public RequestDirector(){
		requestBuilder = new RequestBuilder();
	}
	
	public void initRequest(Agent agent){
		requestBuilder.initRequest(agent);
	}
	
	public void buildRequest(List<Customer> customers, String phone, String name,
							String request, String response){
		if(!requestBuilder.loadUserProfile(phone, customers)){
			requestBuilder.createCustomer(name, phone);
		}
		
		requestBuilder.createRequestContent(request);
		requestBuilder.createReponseContent(response);
	}
	
	public void saveRequest(boolean isAnswered, boolean needCallBack){
		requestBuilder.saveRequest(isAnswered, needCallBack);
	}
}
