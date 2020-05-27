package com.example.ecomerce.website.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ecomerce.website.models.Offer;


@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
	@Modifying
	@Query(value="insert into p_offer(p_id,o_id) values(:productId,:offerId)", nativeQuery = true)
	public void  productOffer(@Param("productId")long productId,@Param("offerId")long offerId );
	
}
