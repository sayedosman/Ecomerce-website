package com.example.ecomerce.website.add;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

	private int id;
	private String firstName;
	private String lastName;
	private int age;
	private List<Contact> contacts;
	
	public User(){}
	
	public User(int id, String firstName, String lastName, int age, List<Contact> contacts) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.contacts = contacts;
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", contacts="
				+ contacts + "]";
	}
	
	
	
}
