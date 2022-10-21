package com.data.account;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Repository;

@Repository
public class User_Data_Response {
	
	//id, name, email, mobile
	
	private int id;
	private String name;
	private String email;
	private String mobile;
	
	public User_Data_Response(){
		
	}
	
	public User_Data_Response(Integer id,String name, String email, String mobile) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
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
	
	
}

