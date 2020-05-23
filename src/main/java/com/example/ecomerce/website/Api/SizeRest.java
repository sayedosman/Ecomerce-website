package com.example.ecomerce.website.Api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.ecomerce.website.apiPackage.Color2;
import com.example.ecomerce.website.apiPackage.Size2;
import com.example.ecomerce.website.models.Color;
import com.example.ecomerce.website.models.Size;
import com.example.ecomerce.website.services.ColorService;
import com.example.ecomerce.website.services.SizeService;

public class SizeRest {

	@Autowired
	private SizeService sizeService;
	@GetMapping(value="/size")
	public List<Size2>getAllColor()
	{
		return sizeService.getAllSize2();
	}
	@PostMapping(value="/size")
	public ResponseEntity<Size>save(@Valid @RequestBody Size size)
	{
		sizeService.save(size);
		return new ResponseEntity<Size>(size,HttpStatus.OK);
	}
	
	
}
