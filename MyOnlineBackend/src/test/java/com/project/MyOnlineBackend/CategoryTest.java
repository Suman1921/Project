package com.project.MyOnlineBackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.project.MyOnlineBackend.Dao.CategoryDao;
import com.project.MyOnlineBackend.model.Category;


public class CategoryTest 
{
	private static AnnotationConfigApplicationContext context;
	static Category category;
	static CategoryDao categoryDao;
	
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.project.MyOnlineBackend");
		context.refresh();
		
		categoryDao = (CategoryDao)context.getBean("categoryDao");
	}
	
	
	@Test
	public void testAddCategory()
	{
		category = new Category();
		category.setCategoryName("Bluetooth Headphones");
		category.setCategoryDescription("Sample Headphones Category");
		category.setActive(true);
		
		assertEquals("Error adding category", true , categoryDao.addCategory(category));
	}
	
	
	
	/*
	@Test
	public void testGetSingleCategory()
	{
		category = categoryDao.getCategory(1);
		
		
		assertEquals("Error", "Television" , category.getCategoryName());
	}
	*/
	
	/*
	@Test
	public void testUpdateCategory()
	{
		category = categoryDao.getCategory(1);
		category.setCategoryName("Television");
		
		
		assertEquals("Error", true , categoryDao.updateCategory(category));
	}
	*/
	
	
	/*
	@Test
	public void testDeleteCategory()
	{
		category = categoryDao.getCategory(1);
		category.setCategoryName("Television");
		
		
		assertEquals("Error", true , categoryDao.deleteCategory(category));
	}
	*/
	
	/*
	@Test
	public void testFetchCategory()
	{
		
		assertEquals("Error", 4 , categoryDao.categoryList().size());
	}
	*/	
}






















