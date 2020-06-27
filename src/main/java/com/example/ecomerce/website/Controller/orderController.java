package com.example.ecomerce.website.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.ecomerce.website.services.BrandService;
import com.example.ecomerce.website.services.CategoryService;
import com.example.ecomerce.website.services.OrdersService;

@Controller
@RequestMapping("/luxury/orders")
public class orderController {
 
	@Autowired
	private OrdersService ordersService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private BrandService brandService;
	
	@GetMapping("/myorders")
	public ModelAndView getAllUserOrder()
	{
		ModelAndView mvn=new ModelAndView("Myorders");
		mvn.addObject("orders",ordersService.getAllUserorders());
		  mvn.addObject("Categeries",categoryService.getAllCategory());
		  mvn.addObject("Brands",brandService.getAllBrand());
		 
		return mvn;
	}
}
