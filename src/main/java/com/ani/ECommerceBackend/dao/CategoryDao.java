package com.ani.ECommerceBackend.dao;

import java.util.List;

import com.ani.ECommerceBackend.model.Category;

public interface CategoryDao {

	 boolean saveCategory(Category category);
	    
	    boolean deleteCategory(Category category);
	    
	    Category getCategory(int categoryId);
	    
	List<Category>    getCategoryList();
}
