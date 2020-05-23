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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="size")

public class Size {
   
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="s_id")
	private long id;
	@Column(name="s_name")
	private String name;
	public Size() {}


	public Size(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	@ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.MERGE)
	 @JoinTable(name = "pro_size", joinColumns = @JoinColumn(name = "s_id", referencedColumnName = "s_id"), inverseJoinColumns = @JoinColumn(name = "p_id", referencedColumnName = "p_id"))
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Product>  products;
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
}
