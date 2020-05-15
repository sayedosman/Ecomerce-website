package com.example.ecomerce.website.auth;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.ecomerce.website.models.User;

public class AppUserDetails implements UserDetails{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	public AppUserDetails(User user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		GrantedAuthority authorty=new GrantedAuthority() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public String getAuthority() {
				System.out.println();
				System.out.println(user.getType().getName());
				System.out.println();
				return user.getType().getName();
				
			}
		};
		
		
		return Arrays.asList(authorty);
	}

	@Override
	public String getPassword() {
		System.out.println();
		System.out.println(user.getPassword());
		System.out.println();
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getEamil();
	}

	

	public User getUser() {
		return user;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
