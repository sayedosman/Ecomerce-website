package com.example.ecomerce.website.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.ecomerce.website.models.Color;
import com.example.ecomerce.website.models.Images;
import com.example.ecomerce.website.models.Product;
import com.example.ecomerce.website.services.BrandService;
import com.example.ecomerce.website.services.CategoryService;
import com.example.ecomerce.website.services.ColorService;

import com.example.ecomerce.website.services.ImagesService;
import com.example.ecomerce.website.services.OfferService;
import com.example.ecomerce.website.services.OrdersService;
import com.example.ecomerce.website.services.ProductService;
import com.example.ecomerce.website.services.SizeService;
import com.example.ecomerce.website.services.productValidation;
import com.example.ecomerce.website.services.uploadFile;

@RestController
@RequestMapping("/admin")
public class adminController {

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private BrandService brandService;
	@Autowired
	private SizeService sizeService;
	@Autowired
	private ColorService colorService;
	@Autowired
	private OfferService offerService;
	@Autowired
	private ProductService productService;
	@Autowired
	private productValidation pv;
	@Autowired
	private uploadFile uploadfile;
	@Autowired
	private ImagesService imageService;
	@GetMapping("/addProduct")
	public ModelAndView show ()
	{
		ModelAndView mvn=new ModelAndView("admin/addProduct");
		mvn.addObject("Categeries",categoryService.getAllCategory());
		 mvn.addObject("Brands",brandService.getAllBrand());
		 
		 mvn.addObject("Colors",colorService.getAllColor());
		  mvn.addObject("Sizes",sizeService.getAllSizes());
		  mvn.addObject("Offers",offerService.getAllOffer());
		  return mvn;
		 
		 
		
	}
	@GetMapping("/addImage")
	public ModelAndView showImage()
	{
		ModelAndView mvn=new ModelAndView("admin/addImage");
		mvn.addObject("Categeries",categoryService.getAllCategory());
		 mvn.addObject("Brands",brandService.getAllBrand());
		 mvn.addObject("Products",productService.getAllProduct());
		 return mvn;
		 
		
	}
	@PostMapping("/upload")
	public ModelAndView upload(@RequestParam("file") MultipartFile file,@RequestParam("product") long ProductId) throws IllegalStateException, IOException
	{
		uploadfile.upload(file);
		Images image=new Images("images/"+file.getOriginalFilename());
		imageService.save(image,ProductId);
		
		ModelAndView mvn=new ModelAndView("index");
		mvn.addObject("Categeries",categoryService.getAllCategory());
		 mvn.addObject("Brands",brandService.getAllBrand());
		 mvn.addObject("Products",productService.getAllProduct());
		  return mvn;
	}
	
	@PostMapping("/addProductProcess")
	public ModelAndView processAdd(@ModelAttribute("product")Product product)
	{
		
		
		if(pv.validate(product).size()>0)
		{
			
			ModelAndView mvn=new ModelAndView("admin/addProduct");
			mvn.addObject("Categeries",categoryService.getAllCategory());
			 mvn.addObject("Brands",brandService.getAllBrand());
			 
			 mvn.addObject("Colors",colorService.getAllColor());
			  mvn.addObject("Sizes",sizeService.getAllSizes());
			  mvn.addObject("Offers",offerService.getAllOffer());
			  mvn.addObject("product",product);
			  mvn.addObject("message",pv.validate(product));
			  return mvn;
		}
		else {
			
			productService.save2(product, product.getColores(), product.getSizs(), product.getOffers());
			ModelAndView mvn=new ModelAndView("index");
			mvn.addObject("Categeries",categoryService.getAllCategory());
			 mvn.addObject("Brands",brandService.getAllBrand());
			 mvn.addObject("Products",productService.getAllProduct());
			  return mvn;
			 
		}
		
	}
}
