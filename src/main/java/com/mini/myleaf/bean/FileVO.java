package com.mini.myleaf.bean;

import org.springframework.web.multipart.MultipartFile;

public class FileVO {

	private String description;
	
	private MultipartFile[] fileData;

	public FileVO() {
		super();
	}

	public FileVO(String description, MultipartFile[] fileData) {
		super();
		this.description = description;
		this.fileData = fileData;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MultipartFile[] getFileData() {
		return fileData;
	}

	public void setFileData(MultipartFile[] fileData) {
		this.fileData = fileData;
	}
	
	
	
}
