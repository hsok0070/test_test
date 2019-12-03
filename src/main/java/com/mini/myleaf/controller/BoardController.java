package com.mini.myleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mini.myleaf.bean.Board;
import com.mini.myleaf.mapper.BoardMapper;

@Controller
@RequestMapping("/ansboard")
public class BoardController {

	@Autowired
	BoardMapper boardMapper;

	@RequestMapping("/boardList")
	public String boardList(Model model) {

		List<Board> bList = boardMapper.getAllBoardList();

		model.addAttribute("boardList", bList);

		return "ansboard/boardList";
	}

	@RequestMapping(value = "/writeBoard")
	public String writeBoard() {

		return "ansboard/writeBoard";
	}

	@RequestMapping(value = "writeBoardAction", method = RequestMethod.POST)
	public String writeBoardAction(Board board) {
		boardMapper.orginInsertBoard(board);

		return "redirect:/ansboard/boardList";
	}

	@RequestMapping("/getBoard")
	public void getBoard(int board, Model model) {
		Board lsm = boardMapper.getBoard(board);
		lsm.setUpHit(lsm.getUpHit()+1);
		//System.out.println(lsm);
		boardMapper.updateBoard(lsm);
		model.addAttribute("board", boardMapper.getBoard(board));
		
	}

	@PostMapping("updateDetail")
	public String updateDetail(Board board, Model model) {
		System.out.println("updateDetail: "+board);
		model.addAttribute("uboard", board);
		return "ansboard/updateDetail";
	}
	
	
	@PostMapping("/updateBoardAction")
	public String updateBoard(Board board) {
		System.out.println("updateAction: "+board);
		
		boardMapper.updateBoard(board);
		
		return "forward:/ansboard/boardList";
	}
	
	@RequestMapping("/deleteBoard")
	public String deleteBoard(int no) {
		boardMapper.deleteBoard(no);
		
		return "redirect:/ansboard/boardList";
	}
	
	@RequestMapping("/answerBoard")
	public String answerBoard(int no, Model model) {
        model.addAttribute("answer", boardMapper.getBoard(no));
		return "ansboard/answerBoard";
	}
	
	
	@RequestMapping("/answerSend")
	public String answerSend(Board board) {
	    Board tempBoard = boardMapper.getBoard(board.getNo());
		tempBoard.setNo(board.getNo());
		tempBoard.setTitle(board.getTitle());
		tempBoard.setName(board.getName());
		tempBoard.setContents(board.getContents());
		tempBoard.setUpHit(board.getUpHit());
		tempBoard.setGroupNo(board.getGroupNo());
		tempBoard.setGroupOrder(board.getGroupOrder()+1);
		tempBoard.setDepth(board.getDepth()+1);
		
		boardMapper.answerBoard(tempBoard);
		boardMapper.updateAnswer(tempBoard);
		
		
		return "redirect:/ansboard/boardList";
	}
	
	
}//Controller


















