package com.ani.ECommerceBackend.dao;

import java.util.List;
import com.ani.ECommerceBackend.model.Supplier;


public interface SupplierDao {

boolean saveSupplier(Supplier supplier);
    
    boolean deleteSupplier(Supplier supplier);
    
    Supplier getSupplier(int supplierId);
    
   List<Supplier>    getSupplierList();
}
