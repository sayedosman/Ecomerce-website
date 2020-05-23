package com.example.ecomerce.website.apiPackage;

public class Images2 {

	private long id;
	private String name;
	private Product2 product;
	public Images2(long id, String name, Product2 product) {
		this.id = id;
		this.name = name;
		this.product = product;
	}
	public Images2(){} 
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
	public Product2 getProduct() {
		return product;
	}
	public void setProduct(Product2 product) {
		this.product = product;
	}
	
}
