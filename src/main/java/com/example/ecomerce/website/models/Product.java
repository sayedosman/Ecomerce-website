package com.example.ecomerce.website.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.Cacheable;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.sun.xml.txw2.annotation.XmlElement;

import org.hibernate.annotations.BatchSize;

@Entity
@Table(name="products")
@XmlRootElement
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="p_id")
	private long id;
	@Column(name="p_name",unique = true)
	private String name;
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
	@JoinColumn(name="cat_id")
	private Category category;
	@ManyToOne(fetch = FetchType.EAGER,cascade =CascadeType.MERGE)
	@JoinColumn(name="b_id")
	private Brand brand;
	@NotEmpty(message = "not empty")
	@Column(name="p_desc")
	private String description;
	@Max(value=50)
	@Column(name="p_quantity")
	private int quantity;
	@Column(name="p_discount")
	private int discount;
	@Max(value=2000)
	@Column(name="p_price")
	private int price;
	@Column(name="sold")
	private int sold;
	@OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL,mappedBy = "product")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Images> images;
	@ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.MERGE ,mappedBy = "products")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Orders> orders;
	
	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	@ManyToMany(fetch = FetchType.EAGER,cascade=CascadeType.MERGE,mappedBy = "productcos")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Color>colors;
	
	@ManyToMany(fetch = FetchType.EAGER,cascade=CascadeType.MERGE,mappedBy = "productS")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Offer> offer;
	public Product() {}
	public List<Offer> getOffer() {
		return offer;
	}
	public void setOffer(List<Offer> offer) {
		this.offer = offer;
	}
	public List<Color> getColors() {
		return colors;
	}
	public void setColors(List<Color> colors) {
		this.colors = colors;
	}
	public List<Size> getSizes() {
		return sizes;
	}
	public void setSizes(List<Size> sizes) {
		this.sizes = sizes;
	}
	@ManyToMany(fetch = FetchType.EAGER,cascade=CascadeType.MERGE,mappedBy = "products")

	@Fetch(value = FetchMode.SUBSELECT)
	private List<Size>sizes;

	public long getId() {
		return id;
	}
	
	public List<Images> getImages() {
		return images;
	}
	public void setImages(List<Images> images) {
		this.images = images;
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
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
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
