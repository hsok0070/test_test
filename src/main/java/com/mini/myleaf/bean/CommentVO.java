package com.mini.myleaf.bean;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentVO {
	
	int c_cno;
	int c_bno;
	String c_name;
	String c_content;
	Date c_calendar;

}
