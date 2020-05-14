package com.example.ecomerce.website.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.ecomerce.website.models.User;
import com.example.ecomerce.website.services.UserService;
@Service
public class AppUserDetailServise implements UserDetailsService{
   @Autowired
	private UserService userService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username);
		System.out.println();
		User user= userService.getUser(username);
		System.out.println(user.getEamil());
		return new AppUserDetails(user);
	}

}
