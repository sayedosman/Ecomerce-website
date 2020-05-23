package com.example.ecomerce.website.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecomerce.website.Repository.ColorRepository;
import com.example.ecomerce.website.Repository.SizeRepository;
import com.example.ecomerce.website.apiPackage.Color2;
import com.example.ecomerce.website.apiPackage.Size2;
import com.example.ecomerce.website.models.Color;
import com.example.ecomerce.website.models.Size;

@Service
public class SizeService {

	@Autowired
	private SizeRepository sizeRepository ;
	@Autowired
	private ProductService productService;

	public List<Size>getAllSizes()
	{
		return sizeRepository.findAll();
	}
	public Size save(Size size)
	{
		sizeRepository.save(size);
		return size;
	}
	public List<Size2>getAllSize2()
	{
		List<Size2>sizes=new ArrayList<Size2>();
		for(Size size: sizeRepository.findAll())
		{
			Size2 Size2 =new Size2();
			Size2.setId(size.getId());
			Size2.setName(size.getName());
			Size2.setProducts(productService.change(size.getProducts()));
			
			sizes.add(Size2);
			
			
		}
		return sizes;
	}

}
