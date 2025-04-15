package BehavioralDesignPattern.ChainOfResposibility;

public class RequestCORClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RequestHandler validator = new ValidationHandler();
		RequestHandler authenticator = new AuthenticationHandler();
		RequestHandler authorizer = new AuthorizationHandler();
		 validator.setNextHandler(authenticator);
		 authenticator.setNextHandler(authorizer);
		 
		 validator.handleRequest(new Request("Prince", "123", "admin"));
		 validator.handleRequest(new Request("user", "password", "admin"));
	}

}
class Request{
	String username;
	String password;
	String role;
	
	public Request(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
abstract class RequestHandler{
	protected RequestHandler nextHandler;
	public void setNextHandler(RequestHandler nextHandler) {
		this.nextHandler = nextHandler;
	}
	abstract void handleRequest(Request request);
}
class ValidationHandler extends RequestHandler{

	@Override
	void handleRequest(Request request) {
		if(!request.getUsername().isBlank() && !request.getPassword().isBlank()) {
			System.out.println("Request VALIDATED Successfully !!");
			if(nextHandler!=null) {
				nextHandler.handleRequest(request);
			}
		}else {
			System.out.println("VALIDATION FAILED !!");
		}
	}
}
class AuthenticationHandler extends RequestHandler{
	
	@Override
	void handleRequest(Request request) {
		if("user".equalsIgnoreCase(request.getUsername()) && "password".equalsIgnoreCase(request.getPassword())){
			System.out.println("Request AUTHENTICATED Successfully !!");
			if(nextHandler!=null) {
				nextHandler.handleRequest(request);
			}
		}else {
			System.out.println("AUTHENTICATION FAILED !!");
		}
	}
}
class AuthorizationHandler extends RequestHandler{
	
	@Override
	void handleRequest(Request request) {
		if("admin".equalsIgnoreCase(request.getRole())) {
			System.out.println("Request AUTHORIZED Successfully !!");
		}else {
			System.out.println("AUTHORIZATION FAILED");
		}
	}
}