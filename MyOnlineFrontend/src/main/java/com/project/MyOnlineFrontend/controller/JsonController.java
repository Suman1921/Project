package com.project.MyOnlineFrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.MyOnlineBackend.Dao.ProductDao;
import com.project.MyOnlineBackend.model.Product;

@Controller
@RequestMapping("/json/data")
public class JsonController 
{
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping("all/products")
	@ResponseBody
	public List<Product> getAllActiveProducts()
	{
		return productDao.listActiveProducts();
	}
	
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getProductsByCategory(@PathVariable int id)
	{
		return productDao.listActiveProductsByCategory(id);
	}
	
	
	@RequestMapping("/admin/all/products")
	@ResponseBody
	public List<Product> getAllProducts()
	{
		return productDao.productList();
	}
	

}
