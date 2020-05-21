package com.example.ecomerce.website.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.jboss.jandex.TypeTarget.Usage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.ecomerce.website.auth.UserValidator;
import com.example.ecomerce.website.models.User;
import com.example.ecomerce.website.services.BrandService;
import com.example.ecomerce.website.services.CategoryService;
import com.example.ecomerce.website.services.ColorService;
import com.example.ecomerce.website.services.SizeService;
import com.example.ecomerce.website.services.UserService;

import io.swagger.models.Model;
@Controller
public class authController {
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private BrandService brandService;
	@Autowired
	private SizeService sizeService;
	@Autowired
	private ColorService colorService;
	 @Autowired
	 private UserValidator userValidator;
	 @Autowired
	 private UserService userService;
	
	@GetMapping("/login")
	public ModelAndView showProducts()
	  {
		System.out.println("welcome");
		  ModelAndView mvn=new ModelAndView("auth/login");
		  mvn.addObject("Categeries",categoryService.getAllCategory());
		  mvn.addObject("Brands",brandService.getAllBrand());
		  return mvn;
	  }
	
	@GetMapping("/register")
	public ModelAndView showRegister()
	{
		List<String>genders=new ArrayList<String>();
		genders.add("Male");
		genders.add("Female");
		 ModelAndView mvn=new ModelAndView("auth/Register");
		 mvn.addObject("Categeries",categoryService.getAllCategory());
		  mvn.addObject("Brands",brandService.getAllBrand());
		  mvn.addObject("genders",genders);
		  return mvn;
	}
	@PostMapping("/processRegister")
	public ModelAndView ProcessRegister( @ModelAttribute("user") User user,BindingResult bindingResult)
	{
		
		userValidator.validate(user,bindingResult);
		if (bindingResult.hasErrors()) {
			bindingResult.getAllErrors().get(0);
			List<String>genders=new ArrayList<String>();
			genders.add("Male");
			genders.add("Female");
			ModelAndView mvn=new ModelAndView("auth/Register");
			 mvn.addObject("Categeries",categoryService.getAllCategory());
			  mvn.addObject("Brands",brandService.getAllBrand());
			  mvn.addObject("user",user);
			  mvn.addObject("genders",genders);
			  mvn.addObject("bindingResult",bindingResult);
			  return mvn;
        }
		userService.save(user,"user");
		ModelAndView mvn=new ModelAndView("index");
		 mvn.addObject("Categeries",categoryService.getAllCategory());
		  mvn.addObject("Brands",brandService.getAllBrand());
		
	   return mvn;

			 
		}
		
		
		
		
		
	
	
	
	
}
