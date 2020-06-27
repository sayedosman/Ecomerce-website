package com.example.ecomerce.website.Api;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.example.ecomerce.website.apiPackage.Product2;
import com.example.ecomerce.website.models.Product;
import com.example.ecomerce.website.services.OrdersService;
import com.example.ecomerce.website.services.ProductService;
import com.example.ecomerce.website.services.uploadFile;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/")
@Api(value="Product",description = "Product API")
public class productRest {

	@Autowired
	private ProductService productService;
	@Autowired
	private uploadFile uploadfile;
	@Autowired
	private OrdersService ordersService;
	//produces = MediaType.APPLICATION_ATOM_XML_VALUE for xml
	@GetMapping(value="/products")
	public List<Product2>getAllProduct()
	{
		return productService.getAllProduct2();
	}
	@GetMapping(value="/product/{ProductName}")
	@ApiOperation(value="View a course Object ",response=Product2.class)
	@ApiResponses(value= {
			@ApiResponse(code = 200,message = "Successfuly retrive Object"),
			@ApiResponse(code = 401,message = "You are not autherized "),
			@ApiResponse(code = 403,message = "Access resource  deneded"),
			@ApiResponse(code = 404,message = "Access resource not found")
	})
	public Product2 getProduct(@PathVariable("ProductName") String ProductName)
	{
		return productService.getproduct2(ProductName);
		
	}
	@PostMapping(value="/products")
	public ResponseEntity<Product2>save(@Valid @RequestBody Product2 product)
	{
		productService.save(product);
		return new ResponseEntity<Product2>(product,HttpStatus.OK);
	}
  @Transactional
	@PutMapping(value="/update")
	public ResponseEntity<Product2>update( @RequestBody Product2 product2)
	{
	  long productId=productService.getAllProduct().get(productService.getAllProduct().size()-1).getId();
		System.out.println(productId+1);
	  ordersService.update(productId+1, product2.getId());
		productService.delete(product2.getId());
		productService.save(product2);
		
		return  new ResponseEntity<Product2>(product2,HttpStatus.OK);
	}
	
	
}