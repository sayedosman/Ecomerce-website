package com.example.ecomerce.website.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="brands")

public class Brand {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="b_id")
	private long id;
	@Column(name="b_name")
	private String name;
	@OneToMany(fetch = FetchType.EAGER,cascade =CascadeType.MERGE,mappedBy ="brand" )
	private List<Product>products;
	public List<Product> getProducts() {
		return products;
	}




	public Brand(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}




	public void setProducts(List<Product> products) {
		this.products = products;
	}




	public Brand() {}
	
	
	

	@Override
	public String toString() {
		return "Brand [brand_Id=" + id + ", name=" + name +  "]";
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
