package com.data.account;

import java.util.ArrayList;
import java.util.List;



public class User_Data {
	
		  
	    public List<User_Data_Response> userList;
	    
	    
	 
	    public List<User_Data_Response> getUserList()
	    {
	  
	        if (userList == null) {
	  
	            userList = new ArrayList<>();
	  
	                   
	        }
	  
	        return userList;
	  
	           
	    }
	  
	    public void
	    setUserList(
	        List<User_Data_Response> userList)
	    {
	        this.userList = userList;
	    }
	}





