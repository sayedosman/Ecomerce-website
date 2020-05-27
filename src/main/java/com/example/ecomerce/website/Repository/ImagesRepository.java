package com.example.ecomerce.website.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.example.ecomerce.website.models.Images;
@Repository
public interface ImagesRepository extends JpaRepository<Images, Long>{ 
	
}
