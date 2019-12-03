package com.mini.myleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mini.myleaf.bean.GreetingsVO;
import com.mini.myleaf.mapper.GreetingsMapper;

@Controller
@RequestMapping("/greet")
public class GreetingsController {
	
	@Autowired
	GreetingsMapper gMapper;
	
	@RequestMapping("/glist")
	private String GreetingsList(Model model) throws Exception {
		model.addAttribute("glist", gMapper.greetList());
		
//		System.out.println(gMapper.greetList());
		
		return "greet/glist";
	}
	//INSERT
	@RequestMapping("/greetings")
	private String Greetings() {
		return "greet/greetings";
	}
	
	@RequestMapping("/greetingsProc")
	private String GreetingsProc(Model model, GreetingsVO greetingsVO) throws Exception {
		gMapper.greetInsert(greetingsVO);
		
		//System.out.println(greetingsVO);
		
		return "redirect:/greet/glist";
	}
	
	//DELETE
	@RequestMapping("/greetDelete/{gno}")
	private String greetDelete(@PathVariable int gno, GreetingsVO greetingsVO) throws Exception{
		
		gMapper.greetDelete(gno);
		return "redirect:/greet/glist";
	}
	
	//<a th:href = "@{delete(BoardTitle=${data.BoardTitle})}" >삭제</a>
	
	//DETAIL - FOR UPDATE
	@RequestMapping("/greetDetail/{gno}")
	private String greetDetail(@PathVariable int gno, Model model) throws Exception {
		
		model.addAttribute("detail", gMapper.greetDetail(gno));
//		System.out.println("detail: "+ gMapper.greetDetail(gno));
		
		return "greet/greetUpdate";
	}
	
	
	//UPDATE
	@RequestMapping("/greetUpdateProc/{gno}")
	private String greetUpdate(@PathVariable int gno,GreetingsVO greetingsVO, Model model) throws Exception {
		
		System.out.println("update : "+greetingsVO);
		gMapper.greetUpdate(greetingsVO);
		
		model.addAttribute("glist", gMapper.greetList());
		System.out.println("update2 : "+greetingsVO);
						
		return "redirect:/greet/glist";

	}

}
