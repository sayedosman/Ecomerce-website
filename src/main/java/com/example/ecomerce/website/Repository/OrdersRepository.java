package com.example.ecomerce.website.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ecomerce.website.models.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
	public List<Orders> findByName(String name);
	@Transactional
	@Modifying
	@Query(value="update order_items set p_id=:productId where p_id=:oldproductId",nativeQuery = true)
	public void updateorder(@Param("productId")long productId,@Param("oldproductId")long oldproductId);

	/*@Query(value=
	+"insert into order_items(o_id,p_id)values (:orderId,:productId);",nativeQuery = true)
	public void updateorder(@Param("orderId")long orderId,@Param("productId")long productId);*/

}
