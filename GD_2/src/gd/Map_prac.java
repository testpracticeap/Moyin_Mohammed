package gd;

import java.util.*;

public class Map_prac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer,String> m1=new HashMap<Integer,String>();
		LinkedHashMap<Integer,String> m2=new LinkedHashMap<Integer,String>();  
		TreeMap<Integer,String> m3=new TreeMap<Integer,String>(); 
		
		m1.put(101,"Moyin");
		m1.put(102, "Mohammed");
		m1.put(103, "Sony");
		
//		Set s1=m1.entrySet();
//		
//		Iterator it = s1.iterator();
//		
//		while(it.hasNext()) {
//			
//			Map.Entry entry=(Map.Entry)it.next();  
//	        System.out.println(entry.getKey()+" "+entry.getValue()); 
//	        
//		}

//	        for(Map.Entry me : m1.entrySet()) {
//	        	
//	        	 System.out.println(me.getKey()+" "+me.getValue()); 
//	        	 
//	        }
//	        m1.entrySet()  
//	        .stream()  
//	        .sorted(Map.Entry.comparingByKey())  
//	        .forEach(System.out::println);  
	        
	        m1.entrySet()  
	        .stream()  
	        //.sorted(Map.Entry.comparingByKey())  
	        //.sorted(Map.Entry.comparingByKey(Comparator.naturalOrder())) 
	        //.sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
	        //.sorted(Map.Entry.comparingByValue())
	        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
	        .forEach(System.out::println);  
//		}
		
	}

}
