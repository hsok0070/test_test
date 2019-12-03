package com.mini.myleaf.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface SBoardFileService {
	
	public void saveFile(MultipartFile img) throws Exception;
	//Exception: service can't do anything when the file is not saved

}
