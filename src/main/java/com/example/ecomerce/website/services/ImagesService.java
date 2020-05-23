package com.example.ecomerce.website.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecomerce.website.Repository.ImagesRepository;
import com.example.ecomerce.website.apiPackage.Category2;
import com.example.ecomerce.website.apiPackage.Images2;
import com.example.ecomerce.website.models.Category;
import com.example.ecomerce.website.models.Images;
@Service
public class ImagesService {

	@Autowired
	private ImagesRepository imagesRepository;
	@Autowired
	private ProductService productService;
	
	public Images save(Images images)
	{
		imagesRepository.save(images);
		return images;
	}
	public List<Images2>getAllImages()
	{
		List<Images2>images=new ArrayList<Images2>();
		for(Images image: imagesRepository.findAll())
		{
			Images2 image2=new Images2();
			image2.setId(image.getId());
			image2.setName(image.getName());
			image2.setProduct(productService.changetoProduct2(image.getProduct()));
			
			images.add(image2);
			
			
		}
		return images;
	}
	
	

}
