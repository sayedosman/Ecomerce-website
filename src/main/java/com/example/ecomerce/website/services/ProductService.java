package com.example.ecomerce.website.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecomerce.website.Repository.ProductRepository;
import com.example.ecomerce.website.models.Category;
import com.example.ecomerce.website.models.Color;
import com.example.ecomerce.website.models.Product;
import com.example.ecomerce.website.models.Size;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product>getAllProduct()
	{
		return productRepository.findAll();
	}
	public Product getProduct(long id )
	{
			for(Product product:getAllProduct())
			    if(product.getId()==id)
			    {
			    	
			    	return product;
			    }
			
			return null;
	}
	
	public Product getproduct(String name)
	{
	for(Product product:getAllProduct())
		{
			System.out.println(product.getName());
			if(product.getName().equals(name))
				return product;
		}
		return null;
	}

}
