package com.example.ecomerce.website.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ecomerce.website.Repository.UserRepository;
import com.example.ecomerce.website.models.Type;
import com.example.ecomerce.website.models.User;
@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TypeService typeService;
	@Autowired
	private PasswordEncoder passwordEncoder;


	public List<User>getAllUser()
	{
		return userRepository.findAll();
	}
	
	
	
	public User getUser(String username )
	{
		  System.out.println(userRepository.findByEmail(username));
		  return userRepository.findByEmail(username) ;
	}
	@Transactional
	public void update(String password,long userId)
	{
		password=passwordEncoder.encode(password);
		userRepository.update(password, userId);
	}
	
	@Transactional
public User save(User user,String role)
{
		Type type;
		if(role.equals("user"))
		{
		 type=typeService.getAllType().get(1);
		}
		else
			 type=typeService.getAllType().get(0);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
	    
	user.setType(type);
	  userRepository.save(user);
	  return user;
	  
}
}
