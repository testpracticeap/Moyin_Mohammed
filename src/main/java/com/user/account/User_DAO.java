package com.user.account;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public class User_DAO {

	public static UserList list = new UserList();

// This static block is executed
// before executing the main
// block

	static {

		// Creating a few Users
		// and adding them to the list
		list.getUserList().add(new UserResponse(1, "Prem", "chapradreams@gmail.com", "9876543210",
				"6-507,Chandrababu nagar, nellore, AP"));

		list.getUserList()
				.add(new UserResponse(2, "Vikash", "abc@gmail.com", "1234567890", "6/45,Vikas nagar, whitefield, KA"));

		list.getUserList().add(
				new UserResponse(3, "Ritesh", "asdjf@gmail.com", "4567890641", "9/8/45,Vijay nagar, Marathahalli, KA"));

		list.getUserList().add(new UserResponse(4, "Suarav", "testf@gmail.com", "3479079308",
				"10/2,Arun Residency, sanjiv nagar, Yaswantpur, KA"));
	}

//// Method to return the list
	public UserList getAllUsers() {
		//System.out.println(list);
//		for (UserResponse user : list.getUserList()) {
//	          System.out.println( user.getName());
//	            }
	        
		return list;
	}

// Method to add an users
// to the user list
	public void addUser(UserResponse user) {
		list.getUserList().add(user);

	}

}
