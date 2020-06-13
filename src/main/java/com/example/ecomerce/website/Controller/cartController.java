package com.example.ecomerce.website.Controller;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.ecomerce.website.auth.AppUserDetails;
import com.example.ecomerce.website.models.Orders;
import com.example.ecomerce.website.models.Product;
import com.example.ecomerce.website.models.User;
import com.example.ecomerce.website.services.BrandService;
import com.example.ecomerce.website.services.CategoryService;
import com.example.ecomerce.website.services.ColorService;
import com.example.ecomerce.website.services.OfferService;
import com.example.ecomerce.website.services.OrdersService;
import com.example.ecomerce.website.services.ProductService;
import com.example.ecomerce.website.services.SizeService;

@Controller
@RequestMapping("/luxury/luxury")
public class cartController {
  
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
	@Autowired
	private OrdersService ordersService;
	 @PostMapping("/cart")
	  public ModelAndView handlCart(@RequestParam("id") int  productId,@RequestParam("quantity") int quantity,HttpSession session ) {
		 
		 if(quantity>0&& quantity<=productService.getProduct(productId).getQuantity() )
		 {
		 double price=0.0;
		  
		 List<Product>products =(List<Product>) session.getAttribute("products");
		  if(products==null) {
			  products=new ArrayList<Product>(); 
		   price=productService.getProduct(productId).getPrice()*quantity;
		   productService.getProduct(productId).setQuantity(quantity);
		  products.add(productService.getProduct(productId));
		   session.setAttribute("products", products);
		   session.setAttribute("price", price);
		   System.out.println("welcome");
		  ModelAndView mvn=new ModelAndView("searchCatogery");
		  mvn.addObject("Categeries",categoryService.getAllCategory());
		  mvn.addObject("Brands",brandService.getAllBrand());
		  System.out.println(productService.getProduct(productId).getCategory().getName());
		  mvn.addObject("category",productService.getProduct(productId).getCategory());
		  return mvn;
		 
		  }
		  else
		  {
			 
			  for(Product product:products)
				  if(product.getId()==productId)
				  {
					  ModelAndView mvn=new ModelAndView("Checkout");
					  mvn.addObject("Categeries",categoryService.getAllCategory());
					  mvn.addObject("Brands",brandService.getAllBrand());
					  mvn.addObject("products",products);
					  
					  return mvn;
				  }
				  else {
			  products=(List<Product>) session.getAttribute("products");
			  productService.getProduct(productId).setQuantity(quantity);
			  price= (double) session.getAttribute("price")+ productService.getProduct(productId).getPrice()*quantity;
			  ModelAndView mvn=new ModelAndView("searchCatogery");
			 
			  mvn.addObject("Categeries",categoryService.getAllCategory());
			  mvn.addObject("Brands",brandService.getAllBrand());
			  mvn.addObject("category",productService.getProduct(productId).getCategory());
				  products.add(productService.getProduct(productId));
			  session.setAttribute("products", products);
			  session.setAttribute("price", price);
			  return mvn;
				  }
			  return null;
		  }
		 }
		 else
		 {
			 ModelAndView mvn=new ModelAndView("singleProduct");
			 
			  mvn.addObject("Categeries",categoryService.getAllCategory());
			  mvn.addObject("Brands",brandService.getAllBrand());
			  mvn.addObject("Product",productService.getProduct(productId));
			return mvn;
		 }
	  }
	 @GetMapping("/checkout")
	 public ModelAndView handleCheckout(HttpSession session)
	 {
		 System.out.println(session.getAttribute("price"));
		 List<Product>products=(List<Product>) session.getAttribute("products");
		 if(products==null)
		 {
			 System.out.println("welcome");
			 System.out.println(session.getAttribute("price"));
		 ModelAndView mvn=new ModelAndView("Checkout");
		 mvn.addObject("Categeries",categoryService.getAllCategory());
		  mvn.addObject("Brands",brandService.getAllBrand());
		  return mvn;
		 }
		 else
		 {
			 System.out.println("welcome2");
			 System.out.println(session.getAttribute("price"));
			 ModelAndView mvn=new ModelAndView("Checkout");
			 mvn.addObject("Categeries",categoryService.getAllCategory());
			  mvn.addObject("Brands",brandService.getAllBrand());
			
		  mvn.addObject("products",products);
		  
		  return mvn;
		  
		
	 }
	 }
	 @GetMapping("/Delete/{productId}")
	 public ModelAndView delete(@PathVariable("productId") long productId,HttpSession session )
	 {
		 List<Product>products=(List<Product>) session.getAttribute("products");
		 double price=(double) session.getAttribute("price");
		 for(Product product:products)
			 if(product.getId()==productId)
			 {
				 price=price-(product.getQuantity()*product.getPrice());
				 System.out.println(product.getQuantity());
				 System.out.println(product.getPrice());
				 System.out.println(price);
		 products.remove(product);
		 session.setAttribute("products",products);
		 System.out.println( session.getAttribute("price"));
		 session.setAttribute("price",price);
		 System.out.println( session.getAttribute("price"));
		 ModelAndView mvn=new ModelAndView("Checkout");
		 mvn.addObject("Categeries",categoryService.getAllCategory());
		  mvn.addObject("Brands",brandService.getAllBrand());
		
	  mvn.addObject("products",products);
	  
	  return mvn;
			 }
		 return null;
			
	 }
	 @PostMapping("/update")
	 public ModelAndView update(@RequestParam("id2") long productId, @RequestParam("quantity") int quantity,HttpSession session)
	 {
		 List<Product>products=(List<Product>) session.getAttribute("products");
		 double price=(double) session.getAttribute("price");
		 for(Product product:products)
			 if(product.getId()==productId)
			 {
				 price=price-(product.getQuantity()*product.getPrice());
				 product.setQuantity(quantity);
				 price=price+(product.getQuantity()*product.getPrice());
				 session.setAttribute("price",price);
				 ModelAndView mvn=new ModelAndView("Checkout");
				 mvn.addObject("Categeries",categoryService.getAllCategory());
				  mvn.addObject("Brands",brandService.getAllBrand());
				
			  mvn.addObject("products",products);
			  
			  return mvn;
					 }
				 return null;
				
	 }
	 @GetMapping("/save")
	 public ModelAndView save(HttpSession session)
	 {
		 ordersService.save(session);
		 List<Product>products=(List<Product>) session.getAttribute("products");
		 double price=(double) session.getAttribute("price");
		 System.out.println("wwelcom");
		 products=null;
		 price=0.0;
	
		 session.setAttribute("products",products);
		 session.setAttribute("price",price);
		 System.out.println("wwelcom2");
		
		 
		 ModelAndView mvn=new ModelAndView("Checkout");
		 mvn.addObject("Categeries",categoryService.getAllCategory());
		  mvn.addObject("Brands",brandService.getAllBrand());
		
		 return mvn;
	 }
	 @GetMapping("/Empty")
	 public ModelAndView Empty(HttpSession session)
	 {
		 if(session.getAttribute("products")!=null)
		 { 
	
		 session.setAttribute("products",null);
		 session.setAttribute("price",null);
		 System.out.println("wwelcom2");
		 }
		 
		 ModelAndView mvn=new ModelAndView("index");
		  mvn.addObject("Categeries",categoryService.getAllCategory());
		  mvn.addObject("Brands",brandService.getAllBrand());
		  mvn.addObject("Products",productService.getAllProduct());
		  return mvn;
	 }
}
