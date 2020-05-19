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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="offers")

public class Offer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="o_id")
	private long id;
	@ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.MERGE)
	@JoinTable(
			name="p_offer",
			joinColumns=@JoinColumn(name="p_id"),
			inverseJoinColumns= @JoinColumn(name="o_id")
			)
	
	private List<Product> productS;
	@Column(name="o_offer")
	private String name;
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Offer() {}
	
	
	public List<Product> getProductS() {
		return productS;
	}


	public void setProductS(List<Product> productS) {
		this.productS = productS;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
