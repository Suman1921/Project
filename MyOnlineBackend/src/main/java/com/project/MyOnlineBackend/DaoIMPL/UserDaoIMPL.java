package com.project.MyOnlineBackend.DaoIMPL;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.MyOnlineBackend.Dao.UserDao;
import com.project.MyOnlineBackend.model.Address;
import com.project.MyOnlineBackend.model.Cart;
import com.project.MyOnlineBackend.model.User;

@Repository("userDao")
@Transactional
public class UserDaoIMPL implements UserDao 
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addUser(User user) 
	{
		try
		{
			user.setEnabled(true);
			sessionFactory.getCurrentSession().persist(user);
			return true;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public User getByEmail(String email) 
	{
		String selectQuery = "FROM User WHERE email = :email";
		try
		{
			return sessionFactory.getCurrentSession().createQuery(selectQuery, User.class).setParameter("email", email).getSingleResult();
		}
		catch (Exception e) 
		{
			return null;
		}
		
	}
	
	@Override
	public boolean addAddress(Address address) 
	{
		try
		{
			sessionFactory.getCurrentSession().persist(address);
			return true;
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
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

}
