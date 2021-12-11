package com.project.MyOnlineFrontend.model;

import java.io.Serializable;

import com.project.MyOnlineBackend.model.Cart;

public class UserModel implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String fullname;
	private String role;
	private Cart cart;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
