package com.project.MyOnlineBackend.Dao;

import java.util.List;

import com.project.MyOnlineBackend.model.Address;
import com.project.MyOnlineBackend.model.Product;

public interface ProductDao 
{
	Product getProduct(int productId);
	List<Product> productList();
	boolean addProduct(Product product);
	boolean updateProduct(Product product);
	boolean deleteProduct(Product product);
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int categoryId);
	
	
}
