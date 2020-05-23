package com.example.ecomerce.website.apiPackage;

import java.util.List;

import javax.persistence.Column;

public class Category2 {

	private long id;
	private String name;
	private List<Product2>products;
	public List<Product2> getProducts() {
		return products;
	}
	public void setProducts(List<Product2> products) {
		this.products = products;
	}
	public Category2(long id,String name){this.id=id;
	this.name=name;}
	public Category2() {}
	
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
