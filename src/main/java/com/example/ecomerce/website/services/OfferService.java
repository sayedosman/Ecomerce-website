package com.example.ecomerce.website.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecomerce.website.Repository.OfferRepository;
import com.example.ecomerce.website.models.Offer;

@Service
public class OfferService {
 
	
	@Autowired
	private OfferRepository offerRepository;
	
	public List<Offer> getAllOffer()
	{
		return offerRepository.findAll();
	}
}
