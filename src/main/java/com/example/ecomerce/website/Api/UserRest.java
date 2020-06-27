package com.example.ecomerce.website.Api;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.ecomerce.website.add.DummyDB;
import com.example.ecomerce.website.add.User;
import com.example.ecomerce.website.services.getDataFromExcel;
@RestController
@RequestMapping("/user")
public class UserRest {

	@Autowired
	private getDataFromExcel getdataFromExcel;
	@PostMapping("/usersfromexcel")
	public void upload (@RequestParam("file") MultipartFile file) throws IOException
	{
		System.out.println("welcome");
		getdataFromExcel.readFromFile(file);
	}
	@GetMapping("/create")
	public void create() throws IOException
	{
		getdataFromExcel.writeToExcel();
	}
	@GetMapping("/users")
	public List<User> list(){
		return new ArrayList<User>(DummyDB.userMap.values());
	}
}
