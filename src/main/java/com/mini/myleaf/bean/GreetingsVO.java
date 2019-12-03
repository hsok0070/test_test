package com.mini.myleaf.bean;

import java.util.Date;

public class GreetingsVO {
	
	private int gno;
	private String gname;
	private String greet;
	private Date gdate;
	public GreetingsVO() {
		super();
	}
	public GreetingsVO(int gno, String gname, String greet, Date gdate) {
		super();
		this.gno = gno;
		this.gname = gname;
		this.greet = greet;
		this.gdate = gdate;
	}
	public int getGno() {
		return gno;
	}
	public void setGno(int gno) {
		this.gno = gno;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getGreet() {
		return greet;
	}
	public void setGreet(String greet) {
		this.greet = greet;
	}
	public Date getGdate() {
		return gdate;
	}
	public void setGdate(Date gdate) {
		this.gdate = gdate;
	}
	@Override
	public String toString() {
		return "GreetingsVO [gno=" + gno + ", gname=" + gname + ", greet=" + greet + ", gdate=" + gdate + "]";
	}

	
	
}
