package com.project.MyOnlineBackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.project.MyOnlineBackend.Dao.ProductDao;
import com.project.MyOnlineBackend.model.Product;

public class ProductTest 
{
	private static AnnotationConfigApplicationContext context;
	
	static Product product;
	static ProductDao productDao;
	
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.project.MyOnlineBackend");
		context.refresh();
		
		productDao = (ProductDao)context.getBean("productDao");
	}
	
	@Test
	public void testAddProduct()
	{
		product = new Product();
		
		product.setName("OnePlus Bullets Wireless Z Bass Edition Bluetooth Headset ");
		product.setBrand("OnePlus");
		product.setDescription("This is some description for OnePlus bluetooth headphones");
		product.setUnitPrice(1700);
		product.setActive(true);
		product.setCategoryId(5);
		product.setSupplierId(1);
		product.setQuantity(8);
		
		assertEquals("Error adding product", true, productDao.addProduct(product));
	}
	
	/*
	@Test
	public void testGetProduct()
	{
		product = productDao.getProduct(1);
		
		
		assertEquals("Error fetching product", "Oppo Selfie S3" , product.getName());
	}
	*/
	/*
	@Test
	public void testUpdateProduct()
	{
		product = productDao.getProduct(1);
		product.setQuantity(8);
		
		
		assertEquals("Error updating product", true , productDao.updateProduct(product));
	}
	*/
}
