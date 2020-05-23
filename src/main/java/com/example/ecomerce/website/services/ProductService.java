package com.example.ecomerce.website.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecomerce.website.Repository.ProductRepository;
import com.example.ecomerce.website.apiPackage.Brand2;
import com.example.ecomerce.website.apiPackage.Category2;
import com.example.ecomerce.website.apiPackage.Color2;
import com.example.ecomerce.website.apiPackage.Offer2;
import com.example.ecomerce.website.apiPackage.Product2;
import com.example.ecomerce.website.apiPackage.Size2;
import com.example.ecomerce.website.models.Brand;
import com.example.ecomerce.website.models.Category;
import com.example.ecomerce.website.models.Color;
import com.example.ecomerce.website.models.Offer;
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
	public Product2 save(Product2 product2)
	{
		Product product=changetoProduct(product2);
		for(Color color:product.getColors())
		System.out.println(color.getName());
		for(Size size:product.getSizes())
		System.out.println(size.getName());
		productRepository.save(product);
		return product2;
	}
	public List<Product2>getAllProduct2()
	{
		
		List<Product2>products=new ArrayList<Product2>();
		for(Product product: productRepository.findAll())
		{
			List<Color2>colors2=new ArrayList<Color2>();
			List<Size2>sizes2=new ArrayList<Size2>();
			List<Offer2>offers2=new ArrayList<Offer2>();
		
			Product2 product2=new Product2();
			product2.setName(product.getName());
			product2.setCategory(new Category2(product.getCategory().getId(),product.getCategory().getName()));
			product2.setBrand(new Brand2(product.getBrand().getId(),product.getBrand().getName()));
			product2.setDescription(product.getDescription());
			product2.setQuantity(product.getQuantity());
			product2.setDiscount(product.getDiscount());
			product2.setPrice(product.getPrice());
			product2.setSold(product.getSold());
	
	       for(Color color:product.getColors())
			{
					
				
				Color2 color2=new Color2(color.getId(),color.getName());
				
				colors2.add(color2);
					
			}
			product2.setColor(colors2);
			
			for(Size size:product.getSizes())
			{
				Size2 size2=new Size2(size.getId(),size.getName());
				
				sizes2.add(size2);
					
			}
			
			product2.setSize(sizes2);
			
			for(Offer offer:product.getOffer())
			{
				Offer2 offer2=new Offer2(offer.getId(),offer.getName());
				offers2.add(offer2);
					
			}
				product2.setOffer(offers2);
			products.add(product2);
			
			
		}
		for(Color2 color2:products.get(0).getColor())
			System.out.println(products.get(0).getName()+"  "+color2.getName());
		
		return products;
	}
	public List<Product2>change(List<Product>products)
	{
			List<Product2>products2=new ArrayList<Product2>();
		for(Product product:products)
		{
			List<Color2>colors2=new ArrayList<Color2>();
			List<Size2>sizes2=new ArrayList<Size2>();
			List<Offer2>offers2=new ArrayList<Offer2>();
		
			Product2 product2=new Product2();
			product2.setName(product.getName());
			product2.setCategory(new Category2(product.getCategory().getId(),product.getCategory().getName()));
			product2.setBrand(new Brand2(product.getBrand().getId(),product.getBrand().getName()));
			product2.setDescription(product.getDescription());
			product2.setQuantity(product.getQuantity());
			product2.setDiscount(product.getDiscount());
			product2.setPrice(product.getPrice());
			product2.setSold(product.getSold());
			for(Color color:product.getColors())
			{
				Color2 color2=new Color2(color.getId(),color.getName());
				colors2.add(color2);								
			}
			product2.setColor(colors2);
			
			for(Size size:product.getSizes())
			{
				Size2 size2=new Size2(size.getId(),size.getName());
				sizes2.add(size2);
					
			}
			product2.setSize(sizes2);
			
		for(Offer offer:product.getOffer())	{				
			Offer2 offer2=new Offer2(offer.getId(),offer.getName());
				offers2.add(offer2);
			
			}
			product2.setOffer(offers2);
			
			
			
			products2.add(product2);
			
			
		}
		return products2;
	}
	public Product2 changetoProduct2(Product product)
	{
			Product2 product2=new Product2();
			product2.setName(product.getName());
			product2.setCategory(new Category2(product.getCategory().getId(),product.getCategory().getName()));
			product2.setBrand(new Brand2(product.getBrand().getId(),product.getBrand().getName()));
			product2.setDescription(product.getDescription());
			product2.setQuantity(product.getQuantity());
			product2.setDiscount(product.getDiscount());
			product2.setPrice(product.getPrice());
			product2.setSold(product.getSold());
				return product2;
	}
	public Product changetoProduct(Product2 product2)
	{
		List<Color>colors=new ArrayList<Color>();
		List<Size>sizes=new ArrayList<Size>();
		List<Offer>offers=new ArrayList<Offer>();
	
			Product product=new Product();
			product.setName(product2.getName());
			product.setCategory(new Category(product2.getCategory().getId(),product2.getCategory().getName()));
			product.setBrand(new Brand(product2.getBrand().getId(),product2.getBrand().getName()));
			product.setDescription(product2.getDescription());
			product.setQuantity(product2.getQuantity());
			product.setDiscount(product2.getDiscount());
			product.setPrice(product2.getPrice());
			product.setSold(product2.getSold());
			 for(Color2 color2:product2.getColor())
				{
						
					
					Color color=new Color(color2.getId(),color2.getName());
					
					colors.add(color);
						
				}
			 product.setColors(colors);
				
				for(Size2 size2:product2.getSize())
				{
					Size size=new Size(size2.getId(),size2.getName());
					
					sizes.add(size);
						
				}
				
				product.setSizes(sizes);
				
				for(Offer2 offer2:product2.getOffer())
				{
					Offer offer=new Offer(offer2.getId(),offer2.getName());
					offers.add(offer);
						
				}
					product.setOffer(offers);
				
				
		
				return product;
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
	public Product2 getproduct2(String name)
	{
	for(Product2 product:getAllProduct2())
		{
			System.out.println(product.getName());
			if(product.getName().equals(name))
				return product;
		}
		return null;
	}

}
