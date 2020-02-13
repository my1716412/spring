package co.yedam.app.board;

import java.util.Date;

public class BoardDTO {
	private int no;
	private String poster;
	private String subject;
	private String contents;
	private Date lastpost;
	private int page;
	private int start;
	private int end;
	private int lastPage;
	
	public BoardDTO() {
		super();
	}
	public BoardDTO(int no, String poster, String subject) {
		super();
		this.no = no;
		this.poster = poster;
		this.subject = subject;
	}
	public BoardDTO(int no2) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BoardDTO [no=" + no + ", poster=" + poster + ", subject=" + subject + ", contents=" + contents
				+ ", lastpost=" + lastpost + ", page=" + page + ", start=" + start + ", end=" + end + ", lastPage="
				+ lastPage + ", views=" + views + "]";
	}
	private int views;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getLastpost() {
		return lastpost;
	}
	public void setLastpost(Date lastpost) {
		this.lastpost = lastpost;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	
}
