package com.project.MyOnlineBackend.DaoIMPL;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.MyOnlineBackend.Dao.CartLineDao;
import com.project.MyOnlineBackend.model.Cart;
import com.project.MyOnlineBackend.model.CartLine;


@Repository("cartLineDao")
@Transactional
public class CartLineDaoIMPL implements CartLineDao 
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<CartLine> list(int cartId) 
	{
		String query = "FROM CartLine where cartId = :cartId";
		return sessionFactory.getCurrentSession()
					.createQuery(query, CartLine.class)
						.setParameter("cartId", cartId)
							.getResultList();
		
	}

	@Override
	public CartLine get(int id) 
	{
		return sessionFactory.getCurrentSession().get(CartLine.class, Integer.valueOf(id));
		
	}

	@Override
	public boolean add(CartLine cartLine) 
	{
		try 
		{
			sessionFactory.getCurrentSession().persist(cartLine);
			return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
		
		
	}

	@Override
	public boolean update(CartLine cartLine) 
	{
		try 
		{
			sessionFactory.getCurrentSession().update(cartLine);
			return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean remove(CartLine cartLine) 
	{
		try 
		{
			sessionFactory.getCurrentSession().remove(cartLine);
			return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public CartLine getByCartAndProduct(int cartId, int productId) 
	{
		String query = "FROM CartLine where cartId = :cartId AND product.id = :productId";
		try
		{
			return sessionFactory.getCurrentSession()
						.createNamedQuery(query, CartLine.class)
							.setParameter("cartId", cartId)
								.setParameter("productId", productId)
									.getSingleResult();
		}
		catch (Exception e) 
		{
			return null;
		}
		
	}

	@Override
	public boolean updateCart(Cart cart) 
	{
		try 
		{
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public List<CartLine> listAvailable(int cartId) 
	{
		String query = "FROM CartLine WHERE cartId =:cartId AND available =:available";
		return sessionFactory.getCurrentSession()
					.createQuery(query, CartLine.class)
						.setParameter("cartId", cartId)
							.setParameter("available", true)
								.getResultList();
		
	}

}
