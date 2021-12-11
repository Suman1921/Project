package com.project.MyOnlineBackend.DaoIMPL;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.MyOnlineBackend.Dao.ProductDao;
import com.project.MyOnlineBackend.model.Address;
import com.project.MyOnlineBackend.model.Product;

@Repository("productDao")
@Transactional
public class ProductDaoIMPL implements ProductDao 
{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Product getProduct(int productId) 
	{
		return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));
	}

	@Override
	public List<Product> productList() 
	{
		return sessionFactory.getCurrentSession().createQuery("FROM Product" , Product.class).getResultList();
	}

	@Override
	public boolean addProduct(Product product) 
	{
		try 
		{	
			product.setActive(true);
			sessionFactory.getCurrentSession().persist(product);
			return true;
		}
		catch(Exception ex) 
		{		
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateProduct(Product product) 
	{
		try 
		{
			sessionFactory.getCurrentSession().update(product);
			return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean deleteProduct(Product product) 
	{	
		try 
		{
			product.setActive(false);
			sessionFactory.getCurrentSession().update(product);
			return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Product> listActiveProducts() 
	{
		String selectActiveCategory = "FROM Product WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		
		query.setParameter("active", true);
		
		return query.getResultList();
		
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) 
	{
		String selectActiveProductsByCategory = "FROM Product WHERE active = :active AND categoryId = :categoryId";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveProductsByCategory);
		query.setParameter("active", true);
		query.setParameter("categoryId", categoryId);
		
		return query.getResultList();
		
	}

	
	
}
