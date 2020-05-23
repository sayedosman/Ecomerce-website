package com.example.ecomerce.website.apiPackage;



import java.util.List;

import com.example.ecomerce.website.models.Brand;
import com.example.ecomerce.website.models.Category;

public class Product2 {
 
	private long id;
	private String name;
	private Category2 category;
	private Brand2 brand;
	private String description;
	private int quantity;
	private int discount;
	private int price;
	private int sold;
	private List<Color2> color;
	private List<Size2> size;
	private List<Offer2> offer;

	
	
	public List<Color2> getColor() {
		return color;
	}
	public void setColor(List<Color2> color) {
		this.color = color;
	}
	public List<Size2> getSize() {
		return size;
	}
	public void setSize(List<Size2> size) {
		this.size = size;
	}
	public List<Offer2> getOffer() {
		return offer;
	}
	public void setOffer(List<Offer2> offer) {
		this.offer = offer;
	}
	public Product2() {}
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
	public Category2 getCategory() {
		return category;
	}
	public void setCategory(Category2 category) {
		this.category = category;
	}
	public Brand2 getBrand() {
		return brand;
	}
	public void setBrand(Brand2 brand) {
		this.brand = brand;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSold() {
		return sold;
	}
	public void setSold(int sold) {
		this.sold = sold;
	}

}
