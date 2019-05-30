package com.ani.ECommerceBackend.model;



//import org.springframework.beans.factory.annotation.Autowired;

import com.ani.ECommerceBackend.daoImpl.CategoryDaoImpl;

public class AppTest {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CategoryDaoImpl categoryDaoImpl=new CategoryDaoImpl();
				
Category category=new Category();
category.setCategoryName("Radha");
category.setCategoryDescription("radha");
category.setCategoryId(101);
categoryDaoImpl.saveCategory(category);
		
	}

}
