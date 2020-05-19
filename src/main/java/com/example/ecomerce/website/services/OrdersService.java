package com.example.ecomerce.website.services;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.ecomerce.website.Repository.OrdersRepository;
import com.example.ecomerce.website.auth.AppUserDetails;
import com.example.ecomerce.website.models.Orders;
import com.example.ecomerce.website.models.Product;
import com.example.ecomerce.website.models.User;

@Service
public class OrdersService {
 
	@Autowired
	private OrdersRepository ordersRepository;
	public List<Orders>getAllOrders()
	{
		return ordersRepository.findAll();
	}
	@Transactional
	public void save(HttpSession session)
	{
		AppUserDetails principal = (AppUserDetails) SecurityContextHolder.getContext()
                  .getAuthentication().getPrincipal();

		 User user=principal.getUser();
		 Orders order=new Orders();
		 order.setAddress(user.getAddress());
				 order.setDate( new Date());
		 order.setName(user.getFirstname());
		 order.setPhone(user.getPhone());
		order.setProducts((List<Product>)session.getAttribute("products"));
		
		System.out.println("welcome1");
		ordersRepository.save(order);
	}
}
