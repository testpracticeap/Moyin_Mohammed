package com.user.account;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;




@RestController

public class UserController {

	
	@Autowired
	private UserResponse response;

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
	  
	    public UserList getuserList()
	    {
		User_DAO user_dao = new User_DAO();
//			System.out.println(user_dao
//	            .getAllUsers());
		
	        return user_dao
	            .getAllUsers();
	    }
	
	 @PostMapping(
		        path = "/",
		        consumes = MediaType.APPLICATION_JSON_VALUE,
		        produces = MediaType.APPLICATION_JSON_VALUE)
		  
		    public ResponseEntity<Object> addUser(
		        @RequestBody UserResponse User)
		    {
		 User_DAO user_dao = new User_DAO();

		        Integer id
		            = user_dao
		                  .getAllUsers()
		                  .getUserList()
		                  .size()
		              + 1;
		  
		        User.setId(id);
		  
		        user_dao
		            .addUser(User);
		  
		        URI location = ServletUriComponentsBuilder
		                  .fromCurrentRequest()
		                  .path("/{id}")
		                  .buildAndExpand(
		                      User.getId())
		                  .toUri();
		  
		               return ResponseEntity
		            .created(location)
		            .build();
		    }
}
	

