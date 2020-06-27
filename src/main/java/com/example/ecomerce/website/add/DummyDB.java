package com.example.ecomerce.website.add;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class DummyDB {

	public static Map<Integer, User> userMap = new HashMap<Integer, User>();
	
	
	
	
	static {
		List<Contact> contacts = new ArrayList<Contact>();
		contacts.add(new Contact(1, "message 1"));
		contacts.add(new Contact(2, "message 2"));
		contacts.add(new Contact(3, "message 3"));
		contacts.add(new Contact(4, "message 4"));
		
		userMap.put(1, new User(1, "ali", "mohammed", 25, contacts));
		userMap.put(2, new User(2, "mohammed", "alla", 25, contacts));
		userMap.put(3, new User(3, "ahmed", "rabie", 28, contacts));
		userMap.put(4, new User(4, "osman", "allaa", 29, contacts));
		userMap.put(5, new User(5, "mostafa", "ahmed", 30, contacts));
	}
	
}
