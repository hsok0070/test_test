package com.mini.myleaf.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mini.myleaf.bean.CommentVO;

@Mapper
public interface CommentMapper {
	
	
	@Insert("insert into comments(c_cno,c_bno,c_name,c_content) values(c_cno.nextval,#{c_bno},#{c_name},#{c_content})")
	public int cinsert(CommentVO vo);
	
	@Select("select * from comments where c_bno=#{c_bno}")
	public List<CommentVO> cselect(int c_bno);

}