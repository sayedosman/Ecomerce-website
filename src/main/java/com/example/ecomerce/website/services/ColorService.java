package com.example.ecomerce.website.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecomerce.website.Repository.ColorRepository;
import com.example.ecomerce.website.apiPackage.Color2;
import com.example.ecomerce.website.apiPackage.Offer2;
import com.example.ecomerce.website.models.Color;
import com.example.ecomerce.website.models.Offer;

@Service
public class ColorService {
	
	@Autowired
	private ColorRepository colorRepository;
	@Autowired
	private ProductService productService;

	public List<Color>getAllColor ()
	{
		return colorRepository.findAll();
	}
	public Color save(Color color)
	{
		colorRepository.save(color);
		return color;
	}
	public List<Color2>getAllColor2()
	{
		List<Color2>colors=new ArrayList<Color2>();
		for(Color color: colorRepository.findAll())
		{
			Color2 color2 =new Color2();
			color2.setId(color.getId());
			color2.setName(color.getName());
			color2.setProducts(productService.change(color.getProductcos()));
			
			colors.add(color2);
			
			
		}
		return colors;
	}


}
