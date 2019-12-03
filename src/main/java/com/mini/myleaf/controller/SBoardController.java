package com.mini.myleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mini.myleaf.bean.SBoardVO;
import com.mini.myleaf.mapper.SBoardMapper;
import com.mini.myleaf.service.SBoardFileService;




@Controller
@RequestMapping("/sboard")
public class SBoardController {
	
	@Autowired
	SBoardMapper sbMapper;
	
	@RequestMapping("/list")	//게시판 목록
	private String sboardList(Model model) throws Exception {
		model.addAttribute("list", sbMapper.sboardList());
		
		System.out.println(sbMapper.sboardList());
		
		return "sboard/list";
	}
		
	//INSERT
	@RequestMapping("/insert")
	private String sboardInsert() {
		return "sboard/insert";
	}
	
	@RequestMapping("/insertProc")
	private String boardInsertProc(Model model, SBoardVO boardVO) throws Exception {
		sbMapper.sboardInsert(boardVO);
		
		return "redirect:/sboard/list";
	}
	
	//상세 페이지
	@RequestMapping("/detail/{sno}")	
	private String sboardDetail(@PathVariable int sno, Model model) throws Exception {
		
		sbMapper.suphit(sno);
		model.addAttribute("detail", sbMapper.sboardDetail(sno));
		
		return "sboard/detail";
		
	}
	//DETAIL - FOR UPDATE
	@RequestMapping("/detailUpdate/{sno}")
	private String greetDetail(@PathVariable int sno, Model model) throws Exception {
		
		model.addAttribute("detail", sbMapper.sboardDetail(sno));
		System.out.println("detail: "+ sbMapper.sboardDetail(sno));
		
		return "sboard/update";
	}
	//UPDATE
	@RequestMapping("/updateProc/{sno}")
	private String boardUpdate(@PathVariable int sno,SBoardVO sboardVO, Model model) throws Exception {
		
		System.out.println("update : "+sboardVO);
		sbMapper.sboardUpdate(sboardVO);	
		
		model.addAttribute("detail", sbMapper.sboardDetail(sno));
		System.out.println("update2 : "+sboardVO);
						
		return "redirect:/sboard/detail/{sno}";
		
	}

	//DELETE
	@RequestMapping("/delete/{sno}")
	private String boardDelete(@PathVariable int sno) throws Exception{
		
		sbMapper.sboardDelete(sno);
		return "redirect:/sboard/list";
	}
		
	
	/*
		String folder = "C:\\upload\\";
		byte[] bytes = file.getBytes();
		Path path = Paths.get(folder+ file.getOriginalFilename());
		Files.write(path, bytes);
		
		sbMapper.saveFile(file);
		
		return "upload";
	}
	
	
	
	@RequestMapping(value = "regg", method = RequestMethod.POST)
	   public String reggallery(@RequestParam("Img") MultipartFile img, @ModelAttribute Board board, Model model,
	         HttpServletRequest request) throws IllegalStateException, IOException {

	      String fileName = img.getOriginalFilename();
	      String fileNameExtension = FilenameUtils.getExtension(fileName).toLowerCase();
	      File destinationFile;
	      String destinationFileName;
	      String fileUrl = "/uploadFiles/";

	      System.out.println("filename:::" + fileName);
	      System.out.println("fine::::" + fileNameExtension);

	      do {
	         destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + fileNameExtension;
	         destinationFile = new File(request.getServletContext().getRealPath(fileUrl) + destinationFileName);

	      } while (destinationFile.exists());

	      destinationFile.getParentFile().mkdirs();

	      String cut = fileUrl + destinationFileName;
	      System.out.println("cut::" + cut);
	      String cut1 = cut.substring(1);
	      System.out.println("cut1" + cut1);
	      System.out.println(destinationFileName);

	      img.transferTo(destinationFile);

	      board.setImagesrc(cut1);
	      boardmapper.RegBoard(board);

	      return "redirect:list";

	   }
	   */
	
}
