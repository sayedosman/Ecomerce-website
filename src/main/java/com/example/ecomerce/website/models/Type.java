package com.example.ecomerce.website.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="type")

public class Type {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	@Column(name="name")
	private String name;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE,mappedBy ="type" )
	private List<User>users;
	



	public Type() {}
	
	public Type(int id,String name) {this.id=id;this.name=name;}
	

	@Override
	public String toString() {
		return "Type [cat_Id=" + id + ", name=" + name +  "]";
	}




	




	public long getId() {
		return id;
	}




	public void setId(long id) {
		this.id = id;
	}




	public List<User> getUsers() {
		return users;
	}




	public void setUsers(List<User> users) {
		this.users = users;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}
}
