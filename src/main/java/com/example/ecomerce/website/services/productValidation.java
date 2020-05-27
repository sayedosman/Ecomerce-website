package com.example.ecomerce.website.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.ecomerce.website.models.Product;

@Service
public class productValidation {

     private Map<String,String>message;

	public Map<String, String> getMessage() {
		return message;
	}

	public void setMessage(Map<String, String> message) {
		this.message = message;
	}

	public  Map<String,String> validate(Product product)
	{
		
		message=new HashMap<String, String>();
		
		if(product.getName().length()<4)
		{
			
			message.put("name", "name more small");
		}
		 if(product.getDescription().length()<20) {
			
			message.put("discription", "discription more small");
		 }
		
		 if(product.getQuantity()<5||product.getQuantity()>50) {
			
			message.put("quantity", "quntity in range from 5 to 50");
		 }
		 
		
		 if(product.getPrice()<150||product.getPrice()>1000) {
			
			message.put("price", "price in range from 150 to 1000");
		 }
			
		 if(product.getOffers()==null) {
			
			message.put("offers", "must chose a offer");
		 }
		 if(product.getColores()==null) {
			
			message.put("colors", "must chose a color");
		 }
		 if(product.getSizs()==null) {
			 
			message.put("size", "must chose a size");
		 }
		
		return message;
	
	
		
		
	}
}
