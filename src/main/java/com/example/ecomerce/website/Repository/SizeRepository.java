package com.example.ecomerce.website.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecomerce.website.models.Size;
@Repository
public interface SizeRepository extends JpaRepository<Size, Long> {
	
}
