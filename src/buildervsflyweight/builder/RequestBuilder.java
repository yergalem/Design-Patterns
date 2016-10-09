package buildervsflyweight.builder;

import java.util.ArrayList;
import java.util.List;

//Concrete Builder classes
public class RequestBuilder implements IRequestBuilder{
	private Request request;

	/*
	 * 1. When a call is connected, the request id and agent information becomes available. 
	 * --> Init the request
	 */
	public void initRequest(Agent agent){
		Call call = new Call();
		call.callPop(agent);
		request = new Request(call.getRequestId(), agent);
		System.out.println("Init Request (request id, agent id): " + call.getRequestId() + ", " + agent.getId());
	}
	
	/*
	 * 2. The agent will ask for the caller's phone number to retrieve the caller's information from the database 
	 * (or if it is a new customer, agent will create user profile)
	 */
	@Override
	public boolean loadUserProfile(String phone, List<Customer> customers) {
		// TODO Auto-generated method stub
		for(Customer customer : customers){
			if(customer.getPhone().equals(phone)){
				request.setRequester(customer);
				System.out.println("Load Customer: " + customer.getName() + ", " + customer.getPhone());
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void createCustomer(String name, String phone){
		Customer customer = new Customer(name, phone);
		request.setRequester(customer);
		System.out.println("Create Customer: " + customer.getName() + ", " + customer.getPhone());
	}

	/*
	 * 3. Agent will get/collect what the caller is requesting during the call (as request content)
	 */
	@Override
	public void createRequestContent(String requestContent) {
		// TODO Auto-generated method stub
		request.setReqContent(requestContent);
		System.out.println("create request content: " + requestContent);
	}

	/*
	 * 4. Agent will answer the questions for the request (as response content) 
	 */
	@Override
	public void createReponseContent(String responseContent) {
		// TODO Auto-generated method stub
		request.setRespContent(responseContent);
		System.out.println("create response content: " + responseContent);
	}

	/*
	 * Agent will set 'isAnswered' and 'needCallback' accordingly and close the call
	 */
	@Override
	public void saveRequest(boolean isAnswered, boolean needCallBack) {
		// TODO Auto-generated method stub
		request.setAnswered(isAnswered);
		request.setNeedCallBack(needCallBack);
		request.save();
		System.out.println("Save Request successful!");
	}

}
