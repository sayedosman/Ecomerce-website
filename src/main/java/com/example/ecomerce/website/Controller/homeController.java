package com.example.ecomerce.website.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.ecomerce.website.services.BrandService;
import com.example.ecomerce.website.services.CategoryService;
import com.example.ecomerce.website.services.ProductService;

@Controller
@RequestMapping("/luxury")
public class homeController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private BrandService brandService;
	@Autowired
	private ProductService productService;
	
  @GetMapping()
  public ModelAndView showProducts()
  {
	  ModelAndView mvn=new ModelAndView("index");
	  mvn.addObject("Categeries",categoryService.getAllCategory());
	  mvn.addObject("Brands",brandService.getAllBrand());
	  mvn.addObject("Products",productService.getAllProduct());
	  return mvn;
  }

}
