package com.mini.myleaf.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mini.myleaf.bean.SBoardVO;
import com.mini.myleaf.bean.GreetingsVO;

@Mapper
public interface GreetingsMapper {

	//목록
	@Select("SELECT * FROM greetings")
	public List<GreetingsVO> greetList();

	//글 등록
	@Insert("INSERT INTO greetings(gno,gname,greet,gdate) VALUES(gno_seq.nextval,#{gname},#{greet},sysdate)")
	public void greetInsert(GreetingsVO greetingsVO);
	
	//글 상세 - 수정할 때 필요
	@Select("SELECT * FROM greetings WHERE gno=#{gno}")
	public List<GreetingsVO> greetDetail(int gno);
	//public BoardVO greetDetail(int gno);
	
	//글 수정
	@Update("UPDATE greetings SET gname=#{gname},greet=#{greet},gdate=sysdate WHERE gno =#{gno}")
	public void greetUpdate(GreetingsVO greetingsVO);
	
	//글 삭제
	@Delete("DELETE FROM greetings WHERE gno=#{gno}")
	public int greetDelete(int gno);

	
}
