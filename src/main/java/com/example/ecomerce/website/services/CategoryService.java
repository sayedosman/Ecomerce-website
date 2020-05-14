package com.example.ecomerce.website.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecomerce.website.Repository.CategoryRepository;
import com.example.ecomerce.website.models.Category;
@Service
public class CategoryService {
    
	@Autowired
	private CategoryRepository categoryRepository;
	public List<Category>getAllCategory()
	{
		return categoryRepository.findAll();
	}
}
