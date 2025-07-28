package com.abhi.rest.webservices.restful_web_services.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class usernotfoundException extends RuntimeException 
{
	public usernotfoundException(String message)
	{
		super(message);
	}

}
