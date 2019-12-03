package com.mini.myleaf.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mini.myleaf.bean.BoardVO;


@Mapper
public interface MW_BoardMapper {

	@Select("select * from mw_leafboard order by b_no")
	public List<BoardVO> list();

	@Select("select * from mw_leafboard where b_no = #{b_no}")
	public BoardVO no(int b_no);

	@Update("update mw_leafboard set b_uphit=b_uphit+1 where b_no =#{b_no}")
	public void uphit(int b_no);

	@Insert("insert into mw_leafboard(b_no,b_name,b_title,b_content) values(b_no.nextval,#{b_name},#{b_title},#{b_content})")
	public void insert(BoardVO vo);

	@Delete("delete from mw_leafboard where b_no = #{b_no}")
	public void delete(@Param("b_no") int b_no);

	@Update("update mw_leafboard set b_title=#{b_title}, b_content=#{b_content} where b_no = #{b_no}")
	public void update(BoardVO vo);
}
