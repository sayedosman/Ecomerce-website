package com.example.ecomerce.website.services;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class uploadFile {

	public void upload(MultipartFile file) throws IllegalStateException, IOException
	{
		file.transferTo(new File("C:\\Users\\sayed\\eclipse-workspace\\ecomerce-website\\src\\main\\resources\\static\\resourses\\images\\"+file.getOriginalFilename()));
	}
}
