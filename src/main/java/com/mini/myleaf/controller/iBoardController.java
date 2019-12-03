package com.mini.myleaf.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mini.myleaf.bean.iBoardVo;
import com.mini.myleaf.mapper.iBoardMapper;


@Controller
@RequestMapping("/iboard")
public class iBoardController { 
	
	@Autowired
	iBoardMapper imapper;
	
	@RequestMapping("/getBoardList")
	public String list(Model model) {
		System.out.println(imapper.list());
		model.addAttribute("list", imapper.list());
		return "iboard/getBoardList";
	}
	
	@RequestMapping("/updateBoard")
	public void update(Model model, iBoardVo vo) {
		model.addAttribute("update",imapper.updateBoard(vo));
		
	}
	
	@RequestMapping("/deleteBoard")
	public String delete(int ino) {
		imapper.deleteBoard(ino);
		return "redirect:/iboard/getBoardList";
	}
	
	@RequestMapping("/insertBoard")
	public String insertA() {
		return "iboard/insertBoard";
	}
	@RequestMapping("/insert1")
	public String insertB(Model model, iBoardVo vo) {
		//model.addAttribute("insert", mapper.insertBoard(vo));
		System.out.println("insertb---->"+imapper.insertBoard(vo));
		return "redirect:/iboard/getBoardList";

	}
	
	@GetMapping("/getBoard")
	public void getBoardlist(Model model, int ino) {
		model.addAttribute("board", imapper.getBoard(ino));
	}
	}
