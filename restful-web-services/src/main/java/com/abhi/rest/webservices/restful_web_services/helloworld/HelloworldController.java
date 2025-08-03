package com.abhi.rest.webservices.restful_web_services.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//expose rest api
@RestController 
public class HelloworldController 
{
	//specific url to rest api
	
	private MessageSource messagesource;
	public HelloworldController (MessageSource messagesource)
	{
		this.messagesource=messagesource;
	}
	
	@RequestMapping(method=RequestMethod.GET,path="/helloworld")
	public String helloWorld()
	{
		return "hello world";
	}

	
	@GetMapping("/hello-world-bean")
	public helloWorldBean helloWorldBean()
	{
		return new helloWorldBean("hello world");
	}
	
    @GetMapping("/hello-world/path-variable/{name}")//This annotation maps HTTP GET requests to this method.The URL pattern contains a path variable {name}.
	public helloWorldBean helloWorlPathVariable(@PathVariable String name) //@PathVariable tells Spring:Get the value of {name} from the URL and assign it to the method parameter name.


	{
		return new helloWorldBean(String.format("hello world,%s",name));
	}
	
	@GetMapping("/helloworldint")
	public String helloWorldInternatiolized()
	{
		Locale locale=LocaleContextHolder.getLocale();
		return	messagesource.getMessage("good.morning.message", null, "default message", locale);
		 
	}

	//Spring automatically detects the user's locale from the HTTP request (usually from the Accept-Language header).
   // Example: If the request has Accept-Language: fr, it picks French.
//example
//en-english(good morning)
//nl-dutch(goedmorgen)
//fr-french(bonjour)

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
