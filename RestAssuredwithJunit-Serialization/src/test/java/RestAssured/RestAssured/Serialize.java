package RestAssured.RestAssured;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Serialize {
	

	
	
	public static void main(String args[]) throws JsonProcessingException
	{
ObjectMapper mapper=new ObjectMapper();	

Scanner sc=new Scanner(System.in);


Faculty facullty=new Faculty();

String facid,Facname,facEmail;

System.out.println("enter Id");
facid=sc.nextLine();

facullty.add("Id",facid);

System.out.println("enter name");
Facname=sc.nextLine();

facullty.add("Name",Facname);
System.out.println("enter emailId");
facEmail=sc.nextLine();

facullty.add("Email",facEmail);


String jsonString=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(facullty);
System.out.println(jsonString);

}

}



class Faculty{
	
	private  Map < String, String>facultydata;
	
	public Faculty()
	
			{
		facultydata=new HashMap();
				
			}
	
	public  Map < String, String>getfacultydata()
	 
			{
				return facultydata;
				
			}
	
	public  void add (String Key, String value)
	 
	{
		 facultydata.put(Key, value);
		
	}
	
	
}