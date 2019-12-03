package com.mini.myleaf.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mini.myleaf.bean.FileVO;
import com.mini.myleaf.service.SBoardFileService;
import com.mini.myleaf.service.SboardFileServiceImpl;

@Controller
public class UploadController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
//	@Autowired
//	SBoardFileService fileService;

	//GET: show upload form page
	@RequestMapping(value="/upload", method = RequestMethod.GET)
	public String uploadFileHandler(Model model) {
		FileVO fileVO = new FileVO();
		model.addAttribute("fileVO", fileVO);
		
		return "upload";
	}
	
	//POST: DO UPLOAD
	@RequestMapping(value="/upload", method = RequestMethod.POST)
	public String uploadFile(HttpServletRequest request, Model model, @ModelAttribute("fileVO") FileVO fileVO) {
		return this.doUpload(request, model, fileVO);
	}
	
	//
	private String doUpload(HttpServletRequest request, Model model, FileVO fileVO) {
		
		String description = fileVO.getDescription();
		System.out.println("description: "+description);
		
		//Root Directory
		String uploadRootPath = request.getServletContext().getRealPath("upload");
		System.out.println("uploadRootPath" + uploadRootPath);
		
		File uploadRootDir = new File(uploadRootPath);
		
		if(!uploadRootDir.exists()) {
			uploadRootDir.mkdirs();
		}
		
		MultipartFile[] fileData = fileVO.getFileData();
		
		List<File> uploadedFiles = new ArrayList<File>();
		List<String> failedFiles = new ArrayList<String>();
		
		for(MultipartFile data: fileData) {
			
			String fname = data.getOriginalFilename();
			System.out.println("File name: "+fname);
			
			if(fname != null && fname.length() >0) {
				try {
					File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator+fname);
					
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
					stream.write(data.getBytes());
					stream.close();
					
					uploadedFiles.add(serverFile);
					System.out.println("Write file " + serverFile);
					
				} catch (Exception e) {
					System.out.println("Error" + fname);
					failedFiles.add(fname);
				}
			}
		}
		
		model.addAttribute("description", description);
		model.addAttribute("uploadedFiles", uploadedFiles);
		model.addAttribute("failedFiles", failedFiles);
				
		return "uploadResult";
		
	}
	
	
	
	
	/*
	@RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = {"multipart/form-data"})
	public String uploadFile(@RequestParam("file") MultipartFile img) {
		
		try {
			service.saveFile(img);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}

		return "/upload";
	}
	*/
	
	
}
