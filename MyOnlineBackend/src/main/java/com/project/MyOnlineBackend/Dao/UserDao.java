package com.project.MyOnlineBackend.Dao;

import com.project.MyOnlineBackend.model.Address;
import com.project.MyOnlineBackend.model.Cart;
import com.project.MyOnlineBackend.model.User;

public interface UserDao 
{
	boolean addUser(User user);
	User getByEmail(String email);
	boolean addAddress(Address address);
	boolean updateCart(Cart cart);

}
