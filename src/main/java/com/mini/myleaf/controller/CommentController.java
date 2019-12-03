package com.mini.myleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mini.myleaf.bean.CommentVO;
import com.mini.myleaf.mapper.CommentMapper;
import com.mini.myleaf.mapper.MW_BoardMapper;


@Controller
@RequestMapping("/mw")
public class CommentController {

	@Autowired
	CommentMapper mapper;

	@Autowired
	MW_BoardMapper mwbmapper;

	@RequestMapping("/boardview2")
	public String Cinsert(CommentVO vo, Model model) {
		// System.out.println(1);
		mapper.cinsert(vo);
		// System.out.println(2);
		model.addAttribute("commentlist", mapper.cselect(vo.getC_bno()));
		model.addAttribute("view", mwbmapper.no(vo.getC_bno()));
		// System.out.println(3);
		return "mw/boardview";
	}

	@RequestMapping("boardview3")
	public String cselect(int c_bno, Model model) {

		System.out.println(c_bno);
		model.addAttribute("clist", mapper.cselect(c_bno));
		model.addAttribute("view", mwbmapper.no(c_bno));

		return "mw/boardview";
	}

}
