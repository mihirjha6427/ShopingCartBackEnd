package com.niit.ShoppingCart.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component("user")// IF THIS IS NOT THERE WE WILL GET BEAN CREATION EXCEPTION AS THEN ONLY WE CAN USE AUTOWIRED//
public class User {
	@Id
	private String id;
	private String name;
	private String password;
	private String mobile;
	private String address;
	private String email;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEMail() {
		return email;
	}
	public void setEMail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	

}
