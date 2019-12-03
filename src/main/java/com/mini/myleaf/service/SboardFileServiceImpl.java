package com.mini.myleaf.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class SboardFileServiceImpl implements SBoardFileService{

	@Autowired
	SBoardFileService fservice;
	
	@Override
	public void saveFile(MultipartFile img) throws Exception {
		
		String folder = "C:/upload/";
		
		//raw data of the photo saved in bytes
		byte[] bytes = img.getBytes();		
		
		//paths = new in Java 1.7.1
		Path path = Paths.get(folder + img.getOriginalFilename());
		
		Files.write(path, bytes);
	}

}
