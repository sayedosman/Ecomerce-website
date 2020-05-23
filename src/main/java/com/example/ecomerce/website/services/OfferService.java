package com.example.ecomerce.website.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecomerce.website.Repository.OfferRepository;
import com.example.ecomerce.website.apiPackage.Brand2;
import com.example.ecomerce.website.apiPackage.Offer2;
import com.example.ecomerce.website.models.Brand;
import com.example.ecomerce.website.models.Offer;

@Service
public class OfferService {
 
	
	@Autowired
	private OfferRepository offerRepository;
	@Autowired
	private ProductService productService;
	public List<Offer> getAllOffer()
	{
		return offerRepository.findAll();
	}
	public Offer save(Offer offer)
	{
		offerRepository.save(offer);
		return offer;
	}
	public List<Offer2>getAllOffer2()
	{
		List<Offer2>offers=new ArrayList<Offer2>();
		for(Offer offer: offerRepository.findAll())
		{
			Offer2 offer2 =new Offer2();
			offer2.setId(offer.getId());
			offer2.setName(offer.getName());
			offer2.setProducts(productService.change(offer.getProductS()));
			
			offers.add(offer2);
			
			
		}
		return offers;
	}
	
}
