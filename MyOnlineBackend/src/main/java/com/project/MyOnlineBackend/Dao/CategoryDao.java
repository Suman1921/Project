package com.project.MyOnlineBackend.Dao;

import java.util.List;

import com.project.MyOnlineBackend.model.Category;

public interface CategoryDao 
{
	Category getCategory(int id);
	List<Category> categoryList();
	boolean addCategory(Category category);
	boolean updateCategory(Category category);
	boolean deleteCategory(Category category);
	
}
