package com.example.ecomerce.website.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecomerce.website.Repository.ColorRepository;
import com.example.ecomerce.website.Repository.SizeRepository;
import com.example.ecomerce.website.models.Size;

@Service
public class SizeService {

	@Autowired
	private SizeRepository sizeRepository ;
	public List<Size>getAllSizes()
	{
		return sizeRepository.findAll();
	}
}
