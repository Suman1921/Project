package com.project.MyOnlineBackend.Dao;

import java.util.List;

import com.project.MyOnlineBackend.model.Cart;
import com.project.MyOnlineBackend.model.CartLine;


public interface CartLineDao 
{
	public List<CartLine> list(int cartId);
	public CartLine get(int id);
	public boolean add(CartLine cartLine);
	public boolean update(CartLine cartLine);
	public boolean remove(CartLine cartLine);
	
	//fetch cartLine through cartId and productId
	public CartLine getByCartAndProduct(int cartId, int productId); 
	
	boolean updateCart(Cart cart);						//updating cart
	public List<CartLine> listAvailable(int cartId);	//list of available cartLine

}
