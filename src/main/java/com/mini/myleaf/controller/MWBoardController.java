package com.mini.myleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mini.myleaf.bean.BoardVO;
import com.mini.myleaf.mapper.CommentMapper;
import com.mini.myleaf.mapper.MW_BoardMapper;

@Controller
@RequestMapping("/mw")
public class MWBoardController {
	
	@Autowired
	MW_BoardMapper mapper;
	
	@Autowired
	CommentMapper cmapper;
	
	@RequestMapping("/boardlist")
	public String test(Model model) {
		model.addAttribute("list", mapper.list());
		
		return "mw/boardlist";
	}
	
	@RequestMapping("/boardview")
	public String test1(Model model, int b_no) {
		int c_bno = b_no;
		mapper.uphit(b_no);
		//System.out.println(1);
		model.addAttribute("view",mapper.no(b_no));
		model.addAttribute("commentlist", cmapper.cselect(c_bno));
		//System.out.println(2);
		
		return "mw/boardview";
	}
	
	@RequestMapping("/boardview1")
	public String test4(int b_no,Model model) {
		//System.out.println(no);
		mapper.delete(b_no);
		System.out.println(1);
		model.addAttribute("list", mapper.list());
		
		return "mw/boardlist";
	}
	
	@RequestMapping("/update")
	  public void test6(Model model,BoardVO vi) {
	  
	  model.addAttribute("view",vi);
	  
	  }
	 
	@RequestMapping("/update1")
	public String test5(BoardVO vo,Model model) {
		//System.out.println(vo);
		mapper.update(vo);
		model.addAttribute("list", mapper.list());
	
		return "/mw/boardlist"; 
	}
	
	
	@RequestMapping("/boardwriting")
	public void test3() {
	}
	
	@RequestMapping("/boardwriting1")
	public String test2(BoardVO vo) {
		//System.out.println(vo);
		mapper.insert(vo);
		//model.addAttribute("insert", "끝");
			
		
		return "redirect:./boardlist";
	}
	
	
}
