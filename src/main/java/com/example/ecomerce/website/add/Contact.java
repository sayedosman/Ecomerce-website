package com.example.ecomerce.website.add;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Contact {

	private int id;
	private String message;
	
	public Contact(){} 
	
	
	public Contact(int id, String message) {
		super();
		this.id = id;
		this.message = message;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "Contact [id=" + id + ", message=" + message + "]";
	}
	
	
}
