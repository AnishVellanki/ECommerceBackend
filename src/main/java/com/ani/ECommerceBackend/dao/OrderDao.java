package com.ani.ECommerceBackend.dao;

import java.util.List;

import com.ani.ECommerceBackend.model.UserOrder;

public interface OrderDao {

	boolean saveOrder(UserOrder userOrder);
	List<UserOrder> getMyOrders(String userName);

	
	
}
