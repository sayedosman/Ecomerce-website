package com.example.ecomerce.website.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ecomerce.website.models.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	   public User findByEmail(String email);
	
}
