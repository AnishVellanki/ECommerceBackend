package com.ani.ECommerceBackend.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Supplier {

	private String supplierName;
	private String supplierDescription;
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierDescription() {
		return supplierDescription;
	}
	public void setSupplierDescription(String supplierDescription) {
		this.supplierDescription = supplierDescription;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	@Id
	private int supplierId;
}
