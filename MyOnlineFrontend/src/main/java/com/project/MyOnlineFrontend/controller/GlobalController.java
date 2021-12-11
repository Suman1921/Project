package com.project.MyOnlineFrontend.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.project.MyOnlineBackend.Dao.UserDao;
import com.project.MyOnlineBackend.model.User;
import com.project.MyOnlineFrontend.model.UserModel;

@ControllerAdvice
public class GlobalController 
{
	@Autowired
	private HttpSession session;
	
	private User user;
	private UserModel userModel;
	
	@Autowired
	private UserDao userDao;
	
	@ModelAttribute("userModel")
	public UserModel getUserModel()
	{
		if(session.getAttribute("userModel")== null)
		{
			//add new UserModel
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			user = userDao.getByEmail(authentication.getName());
			
			if(user!=null)
			{
				userModel = new UserModel();
				userModel.setId(user.getId());
				userModel.setRole(user.getRole());
				userModel.setFullname(user.getFirstName() +" "+ user.getLastName());
				
				if(userModel.getRole().equals("USER"))
				{
					userModel.setCart(user.getCart());
				}
				session.setAttribute("userModel", userModel);
				return userModel;
			}
		}
		
		//return the UserModel if it is already present
		return(UserModel)session.getAttribute("userModel");
	}
	
}
