package gd;

import java.util.*;

public class Collections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> l1=new ArrayList<String>();
		LinkedList<String> l2 = new LinkedList<String>();
		
		HashSet<String> s1=new HashSet<String>();  
		LinkedHashSet<String> s2=new LinkedHashSet<String>(); 
		TreeSet<String> s3=new TreeSet<String>(); 
		
		HashMap<Integer,String> m1=new HashMap<Integer,String>();
		LinkedHashMap<Integer,String> m2=new LinkedHashMap<Integer,String>();  
		TreeMap<Integer,String> m3=new TreeMap<Integer,String>(); 
		
		Hashtable<Integer,String> ht=new Hashtable<Integer,String>();
		
		l2.add("Mohammed");
		l2.add("Team");
		l2.add("T1");
		l2.add("T2");
		l2.add("S1");
		
		Iterator it = l2.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		
	}
		for(String a: l2) {
			System.out.println(a);
		}
}
}
