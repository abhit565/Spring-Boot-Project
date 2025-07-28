package com.abhi.rest.webservices.restful_web_services.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource 
{
	//get users
	@Autowired
	private UserDaoService service;
	//DaoService is something which is managed by spring.
//We have the ad component on it.
//So what we can do is to auto wire it into the user resource.
	
	
	//need use of constructor injection
	public UserResource(UserDaoService service)
	{
		this.service=service;
	}
	@GetMapping("/users") 
	public List<User> retrieveUser()
	{
		return service.findAll();
	}
	
//	@GetMapping("/users/1")
	@GetMapping("/users/{id}")  //all user
	//public List<User> retrieveUser(@PathVariable int id) //we need list of user back
	//{
	//	return service.findone(id);
		
	/*
	 * public User retrieveUser(@PathVariable int id) //we need list of user back
	 * and this is for specific user { return service.findone(id) ;
	 * 
	 * }
	 */
	
	public User retrieveUser(@PathVariable int id) //we need list of user back and this is for specific user
	{
		User user = service.findone(id);
		
		if(user==null)
		{
			throw new usernotfoundException("id"+id);
		}
		return user;
		
		
		
	}
	
	//to add a specific user
	/*@PostMapping("/users")
	public void createUser(@RequestBody User user) //mapped body of incoming http request to java object
	{
		service.save(user);
		
		
		
	}*/
	//for returning 201 created status
	/*
	 * @PostMapping("/users") public ResponseEntity<User>
	 * createUserSimple(@RequestBody User user) { return
	 * ResponseEntity.created(null).build(); }
	 */
	
	
	//for returning 201 created status
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user) //mapped body of incoming http request to java object
	{
		User saveduser = service.save(user);
		//to return the user who has created..like user\4
		
		URI location=ServletUriComponentsBuilder.fromCurrentRequest()//and understand it to the Uri of the current request.
				.path("/{id}")//What we want to do is to add a path slash id
				.buildAndExpand(saveduser.getId())//and we want to replace this variablewhich is presenting here with the ID of the created user.
				.toUri();//And we want to convert it to a U and return it back.
		return ResponseEntity.created(location).build();
		//So we have a location that is returned back and we are returning the location as part of
        //our Response Entity.
		//So to the part of the current request
		//we are appending a variable
		//and replacing it to and replacing it with the value.
		//So id, we are replacing it with the newly created id
		//which is four.
		//So the slash four is appended and returned back,
	}
	//we need 1) /users 2) {id}
	//fromCurrentRequest() for /users
	//And what I would want to do is to replace the

	//ID in here with the idea of the created user.

	//So I would say .build and expand.
	
	/*
	 * What we want to do is to add a path slash id
	 * 
	 * and we want to replace this variable
	 * 
	 * which is presenting here with the ID of the created user.
	 * 
	 * And we want to convert it to a U and return it back.
	 * 
	 * So we have a location that is returned back
	 * 
	 * and we are returning the location as part of
	 * 
	 * our Response Entity.
	 */
}
