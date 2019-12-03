package com.mini.myleaf.bean;

import java.util.Date;

public class SBoardVO {
	
	private int sno;
	private String sname;
	private String stitle;
	private String scontent;
	private int suphit;
	private Date sdate;
	private int sgroup;
	private int sstep;
	private int sindent;
	
	public SBoardVO() {
		super();
	}

	public SBoardVO(int sno, String sname, String stitle, String scontent, int suphit, Date sdate, int sgroup, int sstep,
			int sindent) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.stitle = stitle;
		this.scontent = scontent;
		this.suphit = suphit;
		this.sdate = sdate;
		this.sgroup = sgroup;
		this.sstep = sstep;
		this.sindent = sindent;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getStitle() {
		return stitle;
	}

	public void setStitle(String stitle) {
		this.stitle = stitle;
	}

	public String getScontent() {
		return scontent;
	}

	public void setScontent(String scontent) {
		this.scontent = scontent;
	}

	public int getSuphit() {
		return suphit;
	}

	public void setSuphit(int suphit) {
		this.suphit = suphit;
	}

	public Date getSdate() {
		return sdate;
	}

	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}

	public int getSgroup() {
		return sgroup;
	}

	public void setSgroup(int sgroup) {
		this.sgroup = sgroup;
	}

	public int getSstep() {
		return sstep;
	}

	public void setSstep(int sstep) {
		this.sstep = sstep;
	}

	public int getSindent() {
		return sindent;
	}

	public void setSindent(int sindent) {
		this.sindent = sindent;
	}

	@Override
	public String toString() {
		return "SBoardVO [sno=" + sno + ", sname=" + sname + ", stitle=" + stitle + ", scontent=" + scontent
				+ ", suphit=" + suphit + ", sdate=" + sdate + ", sgroup=" + sgroup + ", sstep=" + sstep + ", sindent="
				+ sindent + "]";
	}

	
}
