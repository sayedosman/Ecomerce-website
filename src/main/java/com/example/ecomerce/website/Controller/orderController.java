package com.example.ecomerce.website.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.ecomerce.website.services.OrdersService;

@Controller
@RequestMapping("/luxury/orders")
public class orderController {
 
	@Autowired
	private OrdersService ordersService;
	@GetMapping("/myorders")
	public ModelAndView getAllUserOrder()
	{
		ModelAndView mvn=new ModelAndView("Myorders");
		mvn.addObject("orders",ordersService.getAllUserorders());
		
		return mvn;
	}
}
