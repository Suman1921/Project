package com.project.MyOnlineBackend.DaoIMPL;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.MyOnlineBackend.Dao.CategoryDao;
import com.project.MyOnlineBackend.model.Category;

@Transactional
@Repository("categoryDao")
public class CategoryDaoIMPL implements CategoryDao 
{
	@Autowired
	SessionFactory sessionFactory;
	
	public Category getCategory(int id) 
	{
		return sessionFactory.getCurrentSession().get(Category.class, id);
	}

	
	public List<Category> categoryList() 
	{
		String selectActiveCategory = "FROM Category WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		return query.getResultList();
		
//		Query query=sessionFactory.getCurrentSession().createQuery("from Category");
//		return query.getResultList();
		
		
	}

	
	public boolean addCategory(Category category) 
	{
		try
		{
			category.setActive(true);
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
		
	}

	
	public boolean updateCategory(Category category) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
		
	}

	
	public boolean deleteCategory(Category category) 
	{
		try
		{
			category.setActive(false);
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}

}
