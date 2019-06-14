package com.ani.ECommerceBackend.dao;

import com.ani.ECommerceBackend.model.User;

public interface UserDao {

	 public boolean addUser(User user);
	    public boolean checkLogin(User user);
	    public User getUser(String email);
	 
}
