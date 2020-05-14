package com.example.ecomerce.website.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="users")

public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="u_id")
	private int userId;
	@Column(name="u_fname")
	private String firstname;
	@Column(name="u_lname")
	private String lastname;
	@Column(name="u_mail")
	private String eamil;
	@Column(name="u_pass")
	private String password;
	@Column(name="u_phone")
	private String phone;
	@Column(name="u_gender")
	private String gender;
	@Column(name="u_address")
	private String address;
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="u_type")
	private Type type;
	public Type getType() {
		return type;
	}


	public void setType(Type type) {
		this.type = type;
	}


	public User() {}
	
	
	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEamil() {
		return eamil;
	}


	public void setEamil(String eamil) {
		this.eamil = eamil;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstname=" + firstname + ", lastname=" + lastname + ", password="
				+ password + ", email=" + eamil + ", gender=" + gender + ", address=" + address + "]";
	}
}
