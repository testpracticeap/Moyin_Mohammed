package com.spring.main;

import org.springframework.stereotype.Repository;

@Repository
public class SampleResponse {



   // message,id, name


	private String msg;
	private long id;
	
	public void setMessage(String msg) {		
		this.msg = msg;
	}
	public String getMessage() {		
		return msg;	
	}
	
	public void setId(long id) {
		this.id =id;
	}
	public long getId() {
		return id;
	}
	
}
