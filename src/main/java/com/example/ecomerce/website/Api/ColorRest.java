package com.example.ecomerce.website.Api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecomerce.website.apiPackage.Color2;
import com.example.ecomerce.website.apiPackage.Product2;
import com.example.ecomerce.website.models.Color;
import com.example.ecomerce.website.models.Product;
import com.example.ecomerce.website.services.ColorService;
import com.example.ecomerce.website.services.ProductService;

@RestController
@RequestMapping("/color")
public class ColorRest {

	@Autowired
	private ColorService colorService;
	@GetMapping(value="/colors")
	public List<Color2>getAllColor()
	{
		return colorService.getAllColor2();
	}
	@PutMapping(value="/colors")
	public ResponseEntity<Color>save(@Valid @RequestBody Color color)
	{
		colorService.save(color);
		return new ResponseEntity<Color>(color,HttpStatus.OK);
	}
}
