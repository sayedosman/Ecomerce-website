package com.example.ecomerce.website.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ecomerce.website.models.Size;
@Repository
public interface SizeRepository extends JpaRepository<Size, Long> {
	
	@Modifying
	@Query(value="insert into pro_size(p_id,s_id) values(:productId,:sizeId)", nativeQuery = true)
	public void  productSize(@Param("productId")long productId,@Param("sizeId")long sizeId );

}
