package com.ani.ECommerceBackend.dao;

import java.util.List;

import com.ani.ECommerceBackend.model.Cart;
import com.ani.ECommerceBackend.model.Product;

public interface CartDao {

boolean saveCart(Product product, int quantity,String userName);
    
    boolean deleteCart(Cart cart);
    
    Cart getCart(int cartId);
    
   List<Cart>    getCartList(String n);
}
