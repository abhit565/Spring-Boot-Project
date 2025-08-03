package com.abhi.rest.webservices.restful_web_services.versioning;

public class Name 
{
	private String firstname;
	private String lasttname;
	public Name(String firstname, String lasttname) {
		super();
		this.firstname = firstname;
		this.lasttname = lasttname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLasttname() {
		return lasttname;
	}
	public void setLasttname(String lasttname) {
		this.lasttname = lasttname;
	}
	@Override
	public String toString() {
		return "Name [firstname=" + firstname + ", lasttname=" + lasttname + "]";
	}

}
