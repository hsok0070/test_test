package com.mini.myleaf.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mini.myleaf.bean.iBoardVo;


@Mapper
public interface iBoardMapper {
	
	@Select("select * from ileafboard")
	public List<iBoardVo> list();

	@Insert("insert into ileafboard(ino, iname, ititle, icontents, ibfile) values (ino_seq.nextval, #{iname}, #{ititle}, #{icontents}, #{ibfile})")
	public int insertBoard(iBoardVo vo);

	@Update("update ileafboard set ititle=#{ititle}, icontents=#{icontents},ibfile=#{ibfile} where ino=#{ino}")
	public int updateBoard(iBoardVo vo);

	@Delete("delete from ileafboard where ino=#{ino}")
	public int deleteBoard(int ino);
	
	@Select("select * from ileafboard where ino=#{ino}")
	public iBoardVo getBoard(int ino);
}
