package com.in28minutes.resr.webservices.restful_web_services.helloworld;

public class helloWorldBean 
{

	private String message; //member variable

	public helloWorldBean(String message) 
	{
		this.message=message;//it will store in hello world bean
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "helloWorldBean [message=" + message + "]";
	}
	

}

//What we are doing is we are setting hello world

//as the value into the message.

//We are creating a bean and returning it back.
