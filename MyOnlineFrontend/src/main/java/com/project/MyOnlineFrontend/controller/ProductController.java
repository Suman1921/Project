package com.project.MyOnlineFrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.MyOnlineBackend.Dao.CategoryDao;
import com.project.MyOnlineBackend.Dao.ProductDao;
import com.project.MyOnlineBackend.model.Product;

@Controller
@RequestMapping(value = "/product/show")
public class ProductController 
{
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	ProductDao productDao;
	
	
	@RequestMapping(value="/all/products")
	public ModelAndView allProducts()
	{
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("title","All Products");
		mv.addObject("userclickallproducts", true);
		mv.addObject("categories", categoryDao.categoryList());
		
		
		return mv;
	}
	
	
	@RequestMapping(value="/category/{id}/products")
	public ModelAndView categoryProducts(@PathVariable("id") int c_id)
	{
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("title","Category Products");
		mv.addObject("userclickcategoryproducts", true);
		mv.addObject("category", categoryDao.getCategory(c_id));
		mv.addObject("categories", categoryDao.categoryList());
		
		return mv;
	}
	
	
	@RequestMapping(value = "/{id}/product")
	public ModelAndView showSingleProducts(@PathVariable("id") int id) 
	{
		
		ModelAndView mv = new ModelAndView("page");

		Product product = productDao.getProduct(id);

		mv.addObject("title", product.getName());
		mv.addObject("product", product);

		mv.addObject("userclicksingleproduct", true);

		return mv;
		
	}
	

}
