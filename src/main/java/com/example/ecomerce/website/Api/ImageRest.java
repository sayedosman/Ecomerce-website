package com.example.ecomerce.website.Api;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.ecomerce.website.models.Images;
import com.example.ecomerce.website.services.ImagesService;
import com.example.ecomerce.website.services.uploadFile;

@RestController
@RequestMapping("/images")
public class ImageRest {

	@Autowired
	private ImagesService imagesService;
	@Autowired
	private uploadFile uploadfile;
	@PostMapping("/uploadImage")
	public void upload(@RequestParam("file") MultipartFile file,@RequestParam("productId")long productId) throws IllegalStateException, IOException
	{
		uploadfile.upload(file);
		Images image=new Images("images/"+file.getOriginalFilename());
		imagesService.save(image, productId);
		
	}

}
