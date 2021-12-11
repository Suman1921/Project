package com.project.MyOnlineFrontend.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.project.MyOnlineBackend.Dao.UserDao;
import com.project.MyOnlineBackend.model.Address;
import com.project.MyOnlineBackend.model.Cart;
import com.project.MyOnlineBackend.model.User;
import com.project.MyOnlineFrontend.model.RegisterModel;

//Handler used to link between model to flow and here write coding which help to perform flow..
//like adding user, updating user or address..
//handler return new object of this model class

@Component("registerHandler")		//used to create bean (used to component of flow)
public class RegisterHandler 
{
	@Autowired
	UserDao userDao;
	
	public RegisterModel init()				//function
	{
		return new RegisterModel();			//new object of register model
	}
	
	
	public void addUser(RegisterModel registerModel, User user) 
	{
		registerModel.setUser(user);
	}
	
	
	public void addAddress(RegisterModel registerModel, Address address) 
	{
		registerModel.setAddress(address);
	}
	
	
	public String validate(User user , MessageContext error)
	{
		String tranResult = "success";
		
		if( ! (user.getPassword().equals(user.getConfirmPassword())))
		{
			error.addMessage(new MessageBuilder()
					.error()
					.source("confirmPassword")
					.defaultText("Password does not match with confirm password!")
					.build());
			
			 tranResult = "failure"; 
		}
		
		if(userDao.getByEmail(user.getEmail()) != null)
		{
			error.addMessage(new MessageBuilder()
					.error()
					.source("email")
					.defaultText("E-mail already taken!")
					.build());
			
			 tranResult = "failure"; 
		}
		
		return tranResult;
	}
	
	
	public String saveAll(RegisterModel registerModel) 
	{
		String transitionValue = "success";
		
		User user = registerModel.getUser();
		if(user.getRole().equals("USER"))
		{
			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
		}
		
		//save the user
		userDao.addUser(user);
		
		//save the billing address
		Address address = registerModel.getAddress();
		address.setUserId(user.getId());
		address.setBilling(true);
		userDao.addAddress(address);
		
		return (transitionValue);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
