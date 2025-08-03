package com.abhi.rest.webservices.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersoncontroller 
{

	@GetMapping("/v1/person")
	public Personv1 getFirstVersionofPerson()
	{
		return new Personv1("abhi");
	}
	@GetMapping("/v2/person")
	public Personv2 getSecondVersionofPerson()
	{
		return new Personv2(new Name("abhi","thakur"));
	}
}
