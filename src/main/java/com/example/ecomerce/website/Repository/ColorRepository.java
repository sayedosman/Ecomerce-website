package com.example.ecomerce.website.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ecomerce.website.models.Color;
@Repository
public interface ColorRepository extends JpaRepository<Color, Long>{ 
	
	@Modifying
	@Query(value="insert into pro_color(p_id,co_id) values(:productId,:colorId)", nativeQuery = true)
	public void  productColor(@Param("productId")long productId,@Param("colorId")long colorId );

}
