package com.project.MyOnlineFrontend.model;

import java.io.Serializable;

import com.project.MyOnlineBackend.model.Address;
import com.project.MyOnlineBackend.model.User;

public class RegisterModel implements Serializable 
{
	
	private static final long serialVersionUID = 1L;
	
	private User user;			//objects
	private Address address;
	
	public User getUser() 
	{
		return user;
	}
	public void setUser(User user) 
	{
		this.user = user;
	}
	public Address getAddress() 
	{
		return address;
	}
	public void setAddress(Address address) 
	{
		this.address = address;
	}
	
	

}
