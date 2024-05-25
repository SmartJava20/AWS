package com.smartjava.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.smartjava.demo.response.ResultResponse;
import com.smartjava.demo.service.S3Service;

@RequestMapping("/s3")
@RestController
public class S3Controller {
	
	@Autowired
	private S3Service s3Service;
	
	@PostMapping("/uploadFile")
	public ResultResponse upload(@RequestParam("file") MultipartFile file) {
		return s3Service.upload(file);
	}
	
	@PostMapping("/deleteFile/{file}")
	public ResultResponse deleteFile(@PathVariable("file") String file) {
		return s3Service.deleteFile(file);
	}
	
	@PostMapping("/download/{file}")
	public ResultResponse download(@PathVariable("file") String file) {
		return s3Service.download(file);
	}
	
	@PostMapping("/deleteBucket/{name}")
	public ResultResponse deleteBucket(@PathVariable("name") String name) {
		return s3Service.deleteBucket(name);
	}


}
