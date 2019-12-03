package com.mini.myleaf.bean;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BoardVO {

	int b_no;
	String b_name;
	String b_title;
	String b_content;
	int b_uphit;
	Date b_calendar;
	
	
	

}
