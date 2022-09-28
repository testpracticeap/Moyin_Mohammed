package com.user.account;

import java.util.ArrayList;
import java.util.List;


public class UserList {

	public List<UserResponse> User_List;
	 
    public List<UserResponse> getUserList()
    {
  
        if (User_List == null) {
  
        	User_List
                = new ArrayList<>();
  
                   
        }
  
        return User_List;
  
           
    }
  
    public void
    setUserList(
        List<UserResponse> UserList)
    {
        this.User_List
            = UserList;
    }

	
}


