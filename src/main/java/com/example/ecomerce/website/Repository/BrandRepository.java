package com.example.ecomerce.website.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecomerce.website.models.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
	
}
