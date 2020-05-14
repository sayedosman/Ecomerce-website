package com.example.ecomerce.website.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecomerce.website.Repository.ProductRepository;
import com.example.ecomerce.website.models.Product;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product>getAllProduct()
	{
		return productRepository.findAll();
	}
	public Optional<Product> getProduct(long id )
	{
		return productRepository.findById(id);
	}

}
