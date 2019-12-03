package com.mini.myleaf.bean;

import java.util.Date;

public class iBoardVo {
	private int ino;
	private String iname;
	private String ititle;
	private String icontents;
	private int iuphit;
	private Date iwdate;
	private String ibfile;
	private int ibparent;
	
	public int getIno() {
		return ino;
	}
	public void setIno(int ino) {
		this.ino = ino;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public String getItitle() {
		return ititle;
	}
	public void setItitle(String ititle) {
		this.ititle = ititle;
	}
	public String getIcontents() {
		return icontents;
	}
	public void setIcontents(String icontents) {
		this.icontents = icontents;
	}
	public int getIuphit() {
		return iuphit;
	}
	public void setIuphit(int iuphit) {
		this.iuphit = iuphit;
	}
	public Date getIwdate() {
		return iwdate;
	}
	public void setIwdate(Date iwdate) {
		this.iwdate = iwdate;
	}
	public String getIbfile() {
		return ibfile;
	}
	public void setIbfile(String ibfile) {
		this.ibfile = ibfile;
	}
	public int getIbparent() {
		return ibparent;
	}
	public void setIbparent(int ibparent) {
		this.ibparent = ibparent;
	}
	@Override
	public String toString() {
		return "BoardVo [ino=" + ino + ", iname=" + iname + ", ititle=" + ititle + ", icontents=" + icontents
				+ ", iuphit=" + iuphit + ", iwdate=" + iwdate + ", ibfile=" + ibfile + ", ibparent=" + ibparent + "]";
	}
	
}
