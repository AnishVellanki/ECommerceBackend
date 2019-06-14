package com.ani.ECommerceBackend.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class User {

private String userName;
@Id
private String email;
private String password;
@ManyToOne(cascade = CascadeType.ALL)
private ShippingAddress address;
public ShippingAddress getAddress() {
	return address;
}
public void setAddress(ShippingAddress address) {
	this.address = address;
}
private String mobileNo;
private String role;
private boolean enabled;



public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getMobileNo() {
	return mobileNo;
}
public void setMobileNo(String mobileNo) {
	this.mobileNo = mobileNo;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}

public boolean isEnabled() {
	return enabled;
}
public void setEnabled(boolean enabled) {
	this.enabled = enabled;
}

}
