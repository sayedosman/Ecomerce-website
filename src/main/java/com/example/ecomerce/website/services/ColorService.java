package com.example.ecomerce.website.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecomerce.website.Repository.ColorRepository;
import com.example.ecomerce.website.models.Color;

@Service
public class ColorService {
	
	@Autowired
	private ColorRepository colorRepository;
	public List<Color>getAllColor ()
	{
		return colorRepository.findAll();
	}

}
