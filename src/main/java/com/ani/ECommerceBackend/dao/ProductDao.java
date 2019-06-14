package com.ani.ECommerceBackend.dao;

import java.util.List;

import com.ani.ECommerceBackend.model.Product;

public interface ProductDao {
	boolean saveProduct(Product product);
    
    boolean deleteProduct(Product product);
    
    Product getProduct(int productId);
    
List<Product>    getProductList();
	
}
