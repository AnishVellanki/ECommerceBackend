package com.ani.ECommerceBackend.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UserOrder {

	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	private int userOrderId;
	@Column
	private Date date;
	@Column
	private int grandTotal;

	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	@ManyToOne(cascade = CascadeType.ALL)
	private ShippingAddress address;
	
	
	
	public ShippingAddress getAddress() {
		return address;
	}
	public void setAddress(ShippingAddress address) {
		this.address = address;
	}
	public int getUserOrderId() {
		return userOrderId;
	}	
	public void setUserOrderId(int userOrderId) {
		this.userOrderId = userOrderId;
	}
		public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(int grandTotal) {
		this.grandTotal = grandTotal;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
