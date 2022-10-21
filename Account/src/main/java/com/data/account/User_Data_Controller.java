package com.data.account;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
@SpringBootApplication
@RequestMapping(path = "/user")
public class User_Data_Controller {

	@Autowired
	private User_Data_Response response;

//	@RequestMapping("/data")
//	public User_Data_Response Sample(
//			@RequestParam(value = "id", defaultValue = "0") int id,
//			@RequestParam(value = "name", defaultValue = "Invalid Name") String name,
//			@RequestParam(value = "email", defaultValue = "Invalid Email") String email,
//			@RequestParam(value = "mobile", defaultValue = "0000000000") String mobile) 
//	{
//		// SampleResponse response = new SampleResponse();
//		response.setId(id);
//		response.setName("Name: " + name);
//		response.setEmail("Email: " + email);
//		response.setMobile("Mobile Number: " + mobile);
//		return response;
//
//	}
	
	@GetMapping(
	        path = "/users",
	        produces = MediaType.APPLICATION_JSON_VALUE)
	  
	    public User_Data getUser_Data()
	    {
	  
	        return User_Data_DAO
	            .getAllUsers();
	    }
	  
	       
	      
	   @PostMapping(
	        path = "/",
	        consumes = MediaType.APPLICATION_JSON_VALUE,
	        produces = MediaType.APPLICATION_JSON_VALUE)
	  
	    public ResponseEntity<Object> addEmployee(
	        @RequestBody User_Data_Response User)
	    {
	  
	        // Creating an ID of an employee
	        // from the number of User_Data
	        Integer id
	            = User_Data_DAO
	                  .getAllUsers()
	                  .getUserList()
	                  .size()
	              + 1;
	  
	        User.setId(id);
	  
	        response
	            .addUser();
	  
	        URI location = ServletUriComponentsBuilder
	                  .fromCurrentRequest()
	                  .path("/{id}")
	                  .buildAndExpand(
	                      response.getId())
	                  .toUri();
	  
	               return ResponseEntity
	            .created(location)
	            .build();
	    }

	}




