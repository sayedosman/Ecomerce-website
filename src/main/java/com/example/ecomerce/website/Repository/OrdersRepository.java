package com.example.ecomerce.website.Repository;

import java.util.List;

import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ecomerce.website.models.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
	public List<Orders> findByName(String name);

}
