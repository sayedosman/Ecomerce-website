package com.example.ecomerce.website.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecomerce.website.Repository.BrandRepository;
import com.example.ecomerce.website.models.Brand;

@Service
public class BrandService {
  
	@Autowired
	private BrandRepository brandRepository;
	public List<Brand>getAllBrand()
	{
		return brandRepository.findAll();
	}
}
