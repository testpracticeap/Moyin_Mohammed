package com.data.account;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
	public class User_Data_DAO {
	  
	    public static User_Data list
	        = new User_Data();
	  
	    // This static block is executed
	    // before executing the main
	    // block
	 
	    static
	    {
	  
	        // Creating a few employees
	        // and adding them to the list
	        list.getUserList().add(
	            new User_Data_Response(
	                1,
	                "Mohammed","mohammed@gmail.com","8765437903"));
	  
	        list.getUserList().add(
	            new User_Data_Response(
	                2, "Vikash",
	                "Kumar1234@gmail.com",
	                "7654321098"));
	  
	        list.getUserList().add(
	            new User_Data_Response(
	                3, "Ritesh",
	                "asdjf@gmail.com","7689540329"));
	  
	        list.getUserList().add(
		            new User_Data_Response(
		                4, "Suarav",
		                "testf@gmail.com","6342710587"));    
	    }
	 
	    // Method to return the list
	    public static User_Data getAllUsers()
	    {
	  
	        return list;
	    }
	  
	       
	        // Method to add an employee
	        // to the employees list
	        public void
	        addUser(User_Data_Response user)
	    {
	        list.getUserList()
	            .add(user);
	           
	    }
	}

