package com.example.ecomerce.website.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.ecomerce.website.models.User;
import com.example.ecomerce.website.services.BrandService;
import com.example.ecomerce.website.services.CategoryService;
import com.example.ecomerce.website.services.ColorService;
import com.example.ecomerce.website.services.SizeService;
@Controller
@RequestMapping("/luxury/auth")
public class authController {
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private BrandService brandService;
	@Autowired
	private SizeService sizeService;
	@Autowired
	private ColorService colorService;
	@GetMapping("/login")
	public ModelAndView showProducts()
	  {
		  ModelAndView mvn=new ModelAndView("auth/Login");
		  mvn.addObject("Categeries",categoryService.getAllCategory());
		  mvn.addObject("Brands",brandService.getAllBrand());
		  return mvn;
	  }
		/*@PostMapping("/login")
		public ModelAndView processSignup(User user) {
			
			ModelAndView mav  = new ModelAndView("index");
			
			System.out.println(user);
			
			mav.addObject("username", user.getEamil());
			
			return mav;
		}*/

	
	
	
}
