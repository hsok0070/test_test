package com.mini.myleaf.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.multipart.MultipartFile;

import com.mini.myleaf.bean.GreetingsVO;
import com.mini.myleaf.bean.SBoardVO;

@Mapper
public interface SBoardMapper {

	//목록
	@Select("select * from sboard")
	public List<SBoardVO> sboardList();

	//상세 페이지
	@Select("select * from sboard where sno = #{sno}")
	public SBoardVO sboardDetail(int sno);
	
	//조회수 증가?
	@Update("UPDATE sboard SET suphit=suphit+1 WHERE sno=#{sno}")
	public boolean suphit(int sno);
	
	//글 등록
	@Insert("insert into sboard(sno,sname,stitle,scontent,suphit,sdate) values(sno_seq.nextval,#{sname},#{stitle},#{scontent},0,sysdate)")
	public void sboardInsert(SBoardVO sboardVO);
	
	//글 수정
	@Update("UPDATE sboard SET sname=#{sname},stitle=#{stitle},scontent=#{scontent},sdate=sysdate WHERE sno =#{sno}")
	public void sboardUpdate(SBoardVO sboardVO);
	
	//글 삭제
	@Delete("DELETE FROM sboard WHERE sno=#{sno}")
	public void sboardDelete(int sno);	
	
}
