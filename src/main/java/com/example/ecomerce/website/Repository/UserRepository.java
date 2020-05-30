package com.example.ecomerce.website.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.ecomerce.website.models.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	   public User findByEmail(String email);
	   @Transactional
	   @Modifying
	   @Query(value="update users set u_pass=:password where u_id=:userId", nativeQuery = true)
	   public void update(@Param("password") String password,@Param("userId")long userId);
	
}
