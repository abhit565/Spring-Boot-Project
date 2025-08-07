package com.abhi.rest.webservices.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersoncontroller 
{

	@GetMapping("/v1/person")   //twitter
	public Personv1 getFirstVersionofPerson()
	{
		return new Personv1("abhi");
	}

	//amazon
	//http://localhost:8080/person?version=1
	@GetMapping(path="/person",params="version=1")
	public Personv1 getFirstVersionofPersonRequest()
	{
		return new Personv1("abhi");
	}
	
	//amazon
	//http://localhost:8080/person?version=2
	@GetMapping(path="/person",params="version=2")
	public Personv2 getSecondVersionofPersonRequest()
	{
		return new Personv2(new Name("abhi","thakur"));
	}
	
	//microsoft
	@GetMapping(path="/person/header",headers="X-API-VERSION=1")
	public Personv1 getFirstVersionofPersonRequestHeader()
	{
		return new Personv1("abhi");
	}
	
	
	
	
	@GetMapping(path="/person/accept",produces="application/vnd.company.app-v1+json")
	public Personv1 getFirstVersionofMediaType()
	{
		return new Personv1("abhi");
	}
	
	
	
	
	
	
	
	
	

	
}
