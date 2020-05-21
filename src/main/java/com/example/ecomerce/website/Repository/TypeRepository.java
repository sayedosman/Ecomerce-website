package com.example.ecomerce.website.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecomerce.website.models.Orders;
import com.example.ecomerce.website.models.Type;

public interface TypeRepository extends JpaRepository<Type, Long>  {

}
