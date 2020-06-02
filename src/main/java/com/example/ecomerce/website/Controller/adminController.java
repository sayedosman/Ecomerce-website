package com.example.ecomerce.website.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
import com.example.ecomerce.website.services.getDataFromExcel;
import com.example.ecomerce.website.services.productValidation;
import com.example.ecomerce.website.services.uploadFile;


@RestController
@RequestMapping("/admin")
public class adminController {

	@Autowired
	private getDataFromExcel getdataFromExcel;
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
	@Autowired
	private OrdersService odersService;
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
	@GetMapping("/editProduct/{productId}")
	public ModelAndView showEdit(@PathVariable("productId")long productId)
	{
		ModelAndView mvn=new ModelAndView("admin/editProduct");
		mvn.addObject("Categeries",categoryService.getAllCategory());
		 mvn.addObject("Brands",brandService.getAllBrand());
		 mvn.addObject("product",productService.getProduct(productId));
		 mvn.addObject("Colors",colorService.getAllColor());
		  mvn.addObject("Sizes",sizeService.getAllSizes());
		  mvn.addObject("Offers",offerService.getAllOffer());
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
			ModelAndView mvn=new ModelAndView("admin/addImage");
			mvn.addObject("Categeries",categoryService.getAllCategory());
			 mvn.addObject("Brands",brandService.getAllBrand());
			  return mvn;
			 
		}
		
	}
	@PostMapping("/editProductProcess")
	public ModelAndView processedit(@ModelAttribute("product")Product product)
	{if(pv.validate(product).size()>0)
	{
		
		ModelAndView mvn=new ModelAndView("admin/addProduct");
		mvn.addObject("Categeries",categoryService.getAllCategory());
		 mvn.addObject("Brands",brandService.getAllBrand());
		 
		 mvn.addObject("Colors",colorService.getAllColor());
		  mvn.addObject("Sizes",sizeService.getAllSizes());
		  mvn.addObject("Offers",offerService.getAllOffer());
		  mvn.addObject("product",product);;
		  mvn.addObject("message",pv.validate(product));
		  return mvn;
	}
	else {
		long productId=productService.getAllProduct().get(productService.getAllProduct().size()-1).getId();
		System.out.println(productId+1);
		odersService.update(productId+1, product.getId());
	
		System.out.println(product.getId());
		productService.delete(product.getId());
		productService.update(product, product.getColores(), product.getSizs(), product.getOffers());
		ModelAndView mvn=new ModelAndView("admin/addImage");
		mvn.addObject("Categeries",categoryService.getAllCategory());
		 mvn.addObject("Brands",brandService.getAllBrand());
		  return mvn;
		 
	}
	}
	@GetMapping("/report/user")
	public  ResponseEntity<InputStreamResource> downloadUser() throws IOException {
		String fileName=getdataFromExcel.writeToExcel();
		InputStreamResource fileStream=new InputStreamResource(new FileInputStream(fileName));
		 HttpHeaders header=new HttpHeaders();
		header.add("Content-disposition", "attachment; filename="+fileName);
		System.out.println(header);
		return ResponseEntity.ok()
				.headers(header)
				 .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
				.body(fileStream);
				
	}
	@GetMapping("/report/products")
	public  ResponseEntity<InputStreamResource> downloadproduct() throws IOException {
		String fileName=getdataFromExcel.writeToExcelProduct();
		InputStreamResource fileStream=new InputStreamResource(new FileInputStream(fileName));
		 HttpHeaders header=new HttpHeaders();
		header.add("Content-disposition", "attachment; filename="+fileName);
		System.out.println(header);
		return ResponseEntity.ok()
				.headers(header)
				 .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
				.body(fileStream);
				
	}
		
}
