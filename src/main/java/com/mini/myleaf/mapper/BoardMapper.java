package com.mini.myleaf.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mini.myleaf.bean.Board;

@Mapper
public interface BoardMapper {
	List<Board> getAllBoardList();
	Board getBoard(int board);
	void insertBoard(Board board);
	void updateBoard(Board board);
	void deleteBoard(int no);
	void answerBoard(Board board);
	void orginInsertBoard(Board board);
	void updateAnswer(Board board);
}
