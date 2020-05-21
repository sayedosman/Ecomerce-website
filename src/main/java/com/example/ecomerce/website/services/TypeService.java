package com.example.ecomerce.website.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecomerce.website.Repository.TypeRepository;
import com.example.ecomerce.website.models.Type;

@Service
public class TypeService {

	@Autowired
	private TypeRepository typeRepository;
	public List<Type>getAllType()
	{
		return typeRepository.findAll();
	}
}
