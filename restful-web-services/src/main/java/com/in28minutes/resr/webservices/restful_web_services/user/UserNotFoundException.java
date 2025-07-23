package com.in28minutes.resr.webservices.restful_web_services.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException 
{
	public UserNotFoundException(String message)
	{
		super(message);
	}
	/*
	 * //So, we have a constructor,
	 * 
	 * which accepts a message,
	 * 
	 * and passes it to the super class,
	 * 
	 * which is "RuntimeException."
	 */
}
