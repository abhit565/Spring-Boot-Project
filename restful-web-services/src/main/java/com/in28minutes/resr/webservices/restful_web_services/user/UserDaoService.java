package com.in28minutes.resr.webservices.restful_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService 
{
	//retrieat ve all the user
	
	//static array list
	private static List<User> users=new ArrayList<>();
	
	
	//Whenever we create a new user,

//we would want to be able to dynamically assign a ID to him,
//and therefore, what I would do
//is I would have a count in here.
	
	private static int userscount=0;
	static
	{
		//So we are creating Adam, who's 30 years old.
		//So we are using LocalDate to fetch the current date
         //and subtracting 30 years from it.
		users.add(new User(++userscount,"adam",LocalDate.now().minusYears(30)));
		users.add(new User(++userscount,"eve",LocalDate.now().minusYears(25)));
	users.add(new User(++userscount,"jim",LocalDate.now().minusYears(20)));
	}
	
	public List<User> findAll()
	{
		return users;
	}
	//we r creating a new user
	public User save(User user)//for post mapping
	{
	//	So the next user who's getting created
		//will get an ID of four and so on and so forth.
		user.setId(++userscount);
		users.add(user);
		return user;
	}
	
	//based on the id
	public User findone(int id)
	{
		Predicate<? super User> predicate=user->user.getId().equals(id);
	//	return users.stream().filter(predicate).findFirst().get();		
		return users.stream().filter(predicate).findFirst().orElse(null);
		
//The way we can retrieve a specific user fromthis list using functional programming is users.stream.
//So we are converting the list to a stream and from the list we would want to filter based on the id.
//So I'll say filter based on a predicate.What I'll do now is do a control one or command oneand I'll say create a local variable predicate.
//So how can you match the user?How do you want to match the user based on So the predicate would be something like this.
//If I'm given a user what I would want to check, I'd want to check something.This is the syntax for creating a Lambda expression ->
		//So given a user, what we want to do is we want to check
//if his id getId.It is getID().equals(id)which is passed in.So are these both IDs the same?
//That's what we would want to check.If the IDs for the user is the samethen we would want to be able to get that user
//and we would want to be able to return it back.
//Over here we are filtering from the list of users only the specific user for whom the ID matches.
//And after that what we want to do is toSo you want to find the first one
//which is matching that specific id.This would return an optional back on that youwould need to do a get() to get the user back.And I would say this return
	}
	
	
	
	
	}

