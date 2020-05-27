package com.example.ecomerce.website.Api;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.ecomerce.website.apiPackage.Product2;
import com.example.ecomerce.website.models.Product;
import com.example.ecomerce.website.services.ProductService;
import com.example.ecomerce.website.services.uploadFile;

@RestController
@RequestMapping("/product")
public class productRest {

	@Autowired
	private ProductService productService;
	@Autowired
	private uploadFile uploadfile;
	//produces = MediaType.APPLICATION_ATOM_XML_VALUE for xml
	@GetMapping(value="/products")
	public List<Product2>getAllProduct()
	{
		return productService.getAllProduct2();
	}
	@GetMapping(value="/product/{ProductName}")
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
	
	
}