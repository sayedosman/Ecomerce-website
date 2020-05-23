package com.example.ecomerce.website.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecomerce.website.Repository.BrandRepository;
import com.example.ecomerce.website.Repository.ProductRepository;
import com.example.ecomerce.website.apiPackage.Brand2;
import com.example.ecomerce.website.apiPackage.Category2;
import com.example.ecomerce.website.apiPackage.Product2;
import com.example.ecomerce.website.models.Brand;
import com.example.ecomerce.website.models.Product;

@Service
public class BrandService {
  
	@Autowired
	private BrandRepository brandRepository;
	@Autowired
	private ProductService productService;
	public List<Brand>getAllBrand()
	{
		return brandRepository.findAll();
	}
	public Brand save(Brand brand)
	{
		brandRepository.save(brand);
		return brand;
	}
	public List<Brand2>getAllBrand2()
	{
		List<Brand2>brands=new ArrayList<Brand2>();
		for(Brand brand: brandRepository.findAll())
		{
			Brand2 brand2=new Brand2();
			brand2.setId(brand.getId());
			brand2.setName(brand.getName());
			brand2.setProducts(productService.change(brand.getProducts()));
			
			brands.add(brand2);
			
			
		}
		return brands;
	}
	
	public Brand getBrand(String name)
	{
		for(Brand brand:getAllBrand())
			if(brand.getName().equals(name))
				return brand;
		return null;
	}
}
