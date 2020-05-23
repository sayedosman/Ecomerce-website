package com.example.ecomerce.website.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Orders {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="o_id")
	private long id;
	@Column(name="o_phone")
	private String phone;
	@Column(name="o_date")
	private Date date;
	@Column(name="u_name")
	private String name;
	@Column(name="u_address")
	private String address;
	
	@ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.MERGE)
	 @JoinTable(name = "order_items", joinColumns = @JoinColumn(name = "o_id", referencedColumnName = "o_id"), inverseJoinColumns = @JoinColumn(name = "p_id", referencedColumnName = "p_id"))

	private List<Product>  products;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
}
