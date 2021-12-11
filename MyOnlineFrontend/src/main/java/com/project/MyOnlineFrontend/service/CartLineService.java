package com.project.MyOnlineFrontend.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.MyOnlineBackend.Dao.CartLineDao;
import com.project.MyOnlineBackend.Dao.ProductDao;
import com.project.MyOnlineBackend.model.Cart;
import com.project.MyOnlineBackend.model.CartLine;
import com.project.MyOnlineBackend.model.Product;
import com.project.MyOnlineFrontend.model.UserModel;



@Service("cartLineService")
public class CartLineService 
{
	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	private CartLineDao cartLineDao;
	
	@Autowired
	private ProductDao productDao;
	
	private Cart getCart()
	{
		return ((UserModel) httpSession.getAttribute("userModel")).getCart();
	}
	
	public List<CartLine>getCartLines()
	{
		Cart cart = this.getCart();
		return cartLineDao.list(cart.getId());
	}
	
	
	public String manageCartLine(int cartLineId, int count)
	{
		CartLine cartLine = cartLineDao.get(cartLineId);
		double oldTotal = cartLine.getTotal();
		Product product = cartLine.getProduct();
		
		//check if that much quantity is available or not
		if(product.getQuantity() < count)
		{
			return "result=unavailable";
		}
		
		//update the cart line
		cartLine.setProductCount(count);
		cartLine.setBuyingPrice(product.getUnitPrice());
		cartLine.setTotal(product.getUnitPrice() * count);
		cartLineDao.update(cartLine);
		
		//update the cart
		Cart cart = this.getCart();
		cart.setGrandTotal(cart.getGrandTotal() - oldTotal + cartLine.getTotal());
		cartLineDao.updateCart(cart);
		
		return "result=updated";
	}
	
	

	
	public String addCartLineProduct(int productId)
	{
		Cart cart = this.getCart();
		String response = null;
	
		CartLine cartLine = cartLineDao.getByCartAndProduct(cart.getId(), productId);
		
		if(cartLine == null)
		{
			cartLine = new CartLine();
			
			Product product = productDao.getProduct(productId);
			
			//transfer the product details to cartline
			
			cartLine.setCartId(cart.getId());
			cartLine.setProduct(product);
			cartLine.setProductCount(1);
			cartLine.setBuyingPrice(product.getUnitPrice());
			cartLine.setTotal(product.getUnitPrice());
			
			//insert the new cartline
			cartLineDao.add(cartLine);
			
			//update the cart
			cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
			cart.setCartLines(cart.getCartLines() + 1);
			cartLineDao.updateCart(cart);
			
			response = "result=added";
		}
		else
		{
			if (cartLine.getProductCount() < 5) 
			{
				// call the manageCartLine method to increase the count
				response = this.manageCartLine(cartLine.getId(), cartLine.getProductCount() + 1);
			} 
			else 
			{
				response = "result=maximum";
			}
		}
		
		return response;
	}
	
	
	
	
	
	public String removeCartLine(int cartLineId) 
	{
		CartLine cartLine = cartLineDao.get(cartLineId);
		// deduct the cart
		// update the cart
		Cart cart = this.getCart();
		cart.setGrandTotal(cart.getGrandTotal() - cartLine.getTotal());
		cart.setCartLines(cart.getCartLines() - 1);
		cartLineDao.updateCart(cart);

		// remove the cartLine
		cartLineDao.remove(cartLine);

		return "result=deleted";
	}
	
}
