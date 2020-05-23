package com.example.ecomerce.website.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecomerce.website.Repository.CategoryRepository;
import com.example.ecomerce.website.apiPackage.Brand2;
import com.example.ecomerce.website.apiPackage.Category2;
import com.example.ecomerce.website.models.Brand;
import com.example.ecomerce.website.models.Category;
@Service
public class CategoryService {
    
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductService productService;
	public List<Category>getAllCategory()
	{
		return categoryRepository.findAll();
	}
	public Category save(Category category)
	{
		categoryRepository.save(category);
		return category;
	}
	public List<Category2>getAllCategory2()
	{
		List<Category2>categories=new ArrayList<Category2>();
		for(Category Category: categoryRepository.findAll())
		{
			Category2 category2=new Category2();
			category2.setId(Category.getId());
			category2.setName(Category.getName());
			category2.setProducts(productService.change(Category.getProducts()));
			
			categories.add(category2);
			
			
		}
		return categories;
	}
	public Category  getCategory(String name)
	{
		for(Category category:getAllCategory())
			if(category.getName().equals(name))
				return category;
		return null;
	}
}
