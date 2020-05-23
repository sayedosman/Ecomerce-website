package com.example.ecomerce.website.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="category")

public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="c_id")
	private long id;
	@Column(name="c_name")
	private String name;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE,mappedBy ="category" )
	private List<Product>products;
	public List<Product> getProducts() {
		return products;
	}




	public Category(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}




	public void setProducts(List<Product> products) {
		this.products = products;
	}




	public Category() {}
	
	
	

	@Override
	public String toString() {
		return "Category [cat_Id=" + id + ", name=" + name +  "]";
	}




	public long getId() {
		return id;
	}




	public void setId(long id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}
}
