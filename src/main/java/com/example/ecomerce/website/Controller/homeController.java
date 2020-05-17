package com.example.ecomerce.website.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.ecomerce.website.models.Color;
import com.example.ecomerce.website.models.Size;
import com.example.ecomerce.website.services.BrandService;
import com.example.ecomerce.website.services.CategoryService;
import com.example.ecomerce.website.services.ColorService;
import com.example.ecomerce.website.services.OfferService;
import com.example.ecomerce.website.services.ProductService;
import com.example.ecomerce.website.services.SizeService;

@Controller
@RequestMapping("/luxury")
public class homeController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private BrandService brandService;
	@Autowired 
	private ProductService productService;
	@Autowired
	private SizeService sizeService;
	@Autowired
	private ColorService colorService;
	@Autowired
	private OfferService offerService;
  @GetMapping()
  public ModelAndView showProducts()
  {
	  ModelAndView mvn=new ModelAndView("index");
	  mvn.addObject("Categeries",categoryService.getAllCategory());
	  mvn.addObject("Brands",brandService.getAllBrand());
	  mvn.addObject("Products",productService.getAllProduct());
	  return mvn;
  }
  @PostMapping("/handl")
  public ModelAndView handleMyURL(@RequestParam("name") String search) {
       if(categoryService.getCategory(search)!=null)
       {
    	   ModelAndView mvn=new ModelAndView("searchCatogery");
    		  mvn.addObject("Categeries",categoryService.getAllCategory());
    		  mvn.addObject("Brands",brandService.getAllBrand());
    		  mvn.addObject("category", categoryService.getCategory(search));
    		  return mvn;
       }
       else if(brandService.getBrand(search)!=null)
       {
    	   ModelAndView mvn=new ModelAndView("searchBrand");
 		  mvn.addObject("Categeries",categoryService.getAllCategory());
 		  mvn.addObject("Brands",brandService.getAllBrand());
 		  mvn.addObject("brand", brandService.getBrand(search));
 		  return mvn;
       }
       else  if(productService.getproduct(search)!=null)
       {
    	   
    	   
    	   ModelAndView mvn=new ModelAndView("searchCatogery");
    		  mvn.addObject("Categeries",categoryService.getAllCategory());
    		  mvn.addObject("Brands",brandService.getAllBrand());
    		  mvn.addObject("category", productService.getproduct(search).getCategory());
    		  return mvn;
       }
       else
       {
    	   ModelAndView mvn=new ModelAndView("index");
    		  mvn.addObject("Categeries",categoryService.getAllCategory());
    		  mvn.addObject("Brands",brandService.getAllBrand());
    		  mvn.addObject("Products",productService.getAllProduct());
    		  return mvn;
       }
	 
  }
  
  
  
  @GetMapping("/single/{ProductId}")
  public ModelAndView showProduct(@PathVariable("ProductId") long ProductId)
  {
	 
	  
	  ModelAndView mvn=new ModelAndView("singleProduct");
	  mvn.addObject("Categeries",categoryService.getAllCategory());
	  mvn.addObject("Brands",brandService.getAllBrand());
	  mvn.addObject("Product",productService.getProduct(ProductId));
	  mvn.addObject("Products",productService.getAllProduct());
	  
	  return mvn;
  }
}
