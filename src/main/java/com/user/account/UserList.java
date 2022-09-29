package com.user.account;

import java.util.ArrayList;
import java.util.List;


public class UserList {

	public List<UserResponse> UserList;
	 
    public List<UserResponse> getUserList()
    {
  
        if (UserList == null) {
  
        	UserList
                = new ArrayList<>();
  
                   
        }
       // System.out.println(UserList);
      return UserList;
  
           
    }
  
    public void
    setUserList(
        List<UserResponse> UserList)
    {
        this.UserList
            = UserList;
    }

	
}


