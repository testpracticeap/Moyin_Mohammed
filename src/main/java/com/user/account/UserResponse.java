package com.user.account;

import org.springframework.stereotype.Repository;

@Repository


public class UserResponse {
	
	//id, name, email, mobile, address
	
	private long id;
	private String name;
	private String email;
	private String mobile;
	private String address;
	
	public UserResponse(){
		
	}
	
	public UserResponse(long id,String name, String email, String mobile, String address) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
	}
	
	
	
	public void setId(long id) {
		this.id = id;
	}
	public long getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
		
	}
	
	public void setMobile(String Mobile) {
		this.mobile = Mobile;
	}
	public String getMobile() {
		return mobile;	
	}
	
	public void setAddress(String Address) {
		this.address = Address;
	}
	public String getAddress() {
		return address;	
	}
	
}

