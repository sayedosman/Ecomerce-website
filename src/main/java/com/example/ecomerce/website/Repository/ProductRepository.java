package com.example.ecomerce.website.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ecomerce.website.models.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	

	//@Modifying
//	@Query("inser into Product(name,category,brand,description,quantity,discount,price,sold values")
}
