package com.user.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@SpringBootApplication

public class UserController {

	
	@Autowired
	private UserResponse response;
//	private User_DAO user_dao;

	@RequestMapping("/user")
	public UserResponse Sample(
			@RequestParam(value = "id", defaultValue = "0") long id,
			@RequestParam(value = "name", defaultValue = "Invalid Name") String name,
			@RequestParam(value = "email", defaultValue = "Invalid Email") String email,
			@RequestParam(value = "mobile", defaultValue = "0000000000") String mobile,
			@RequestParam(value = "address", defaultValue = "InValid Address") String address
			)
	{
		// UserResponse response = new UserResponse();
		response.setId(id);
		response.setName(name);
		response.setEmail(email);
		response.setMobile(mobile);
		response.setAddress(address);
		return response;

	}
	
	@GetMapping(
	        path = "/",
	        produces = MediaType.APPLICATION_JSON_VALUE)
	  
	    public UserList getUserList()
	    {
		User_DAO user_dao = new User_DAO();
	        return user_dao
	            .getAllUsers();
	    }
}
	

