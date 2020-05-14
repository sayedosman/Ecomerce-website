package com.example.ecomerce.website.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecomerce.website.Repository.UserRepository;
import com.example.ecomerce.website.models.User;
@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public List<User>getAllUser()
	{
		return userRepository.findAll();
	}
	public User getUser(String username )
	{
		return  userRepository.findByEamil(username);
	}

}
