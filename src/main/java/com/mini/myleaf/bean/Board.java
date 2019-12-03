package com.mini.myleaf.bean;

import java.util.Date;

public class Board {
	private int no;             // 글 번호
	private String name;        // 작성자
	private String title;       // 글 제목
	private String contents;    // 글 내용
	private int upHit;          // 글 조회수
	private Date wdate;         // 등록일
	private String bFile;       // 첨부파일
	private int bParent;        // 부모글 번호
	private int groupNo;        // 글 그룹번호 
	private int depth;          // 답글의 깊이
	private int groupOrder;     // 답글의 순서 
	
	public int getDepth() {
		return depth;
	}


	public void setDepth(int depth) {
		this.depth = depth;
	}


	public int getGroupOrder() {
		return groupOrder;
	}


	public void setGroupOrder(int groupOrder) {
		this.groupOrder = groupOrder;
	}


	public Board() {
	}

	
	public Board(int no, String name, String title, String contents, int upHit, Date wdate, String bFile, int bParent) {
		super();
		this.no = no;
		this.name = name;
		this.title = title;
		this.contents = contents;
		this.upHit = upHit;
		this.wdate = wdate;
		this.bFile = bFile;
		this.bParent = bParent;
	}


	public int getGroupNo() {
		return groupNo;
	}


	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}


	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getUpHit() {
		return upHit;
	}

	public void setUpHit(int upHit) {
		this.upHit = upHit;
	}

	public Date getWdate() {
		return wdate;
	}

	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}

	public String getbFile() {
		return bFile;
	}

	public void setbFile(String bFile) {
		this.bFile = bFile;
	}

	public int getbParent() {
		return bParent;
	}

	public void setbParent(int bParent) {
		this.bParent = bParent;
	}


	@Override
	public String toString() {
		return "Board [no=" + no + ", name=" + name + ", title=" + title + ", contents=" + contents + ", upHit=" + upHit
				+ ", wdate=" + wdate + ", bFile=" + bFile + ", bParent=" + bParent + ", groupNo=" + groupNo + ", depth="
				+ depth + ", groupOrder=" + groupOrder + "]";
	}


	
	
}
