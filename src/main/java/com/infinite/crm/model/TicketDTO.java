package com.infinite.crm.model;

public class TicketDTO {
	
	private Long tid;
	private String username;
	private String email;
	private String issue;
	private String status;
	private String raiseddate;
	public Long getTid() {
		return tid;
	}
	public void setTid(Long tid) {
		this.tid = tid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRaiseddate() {
		return raiseddate;
	}
	public void setRaiseddate(String raiseddate) {
		this.raiseddate = raiseddate;
	}
	public TicketDTO(Long tid, String username, String email, String issue, String status, String raiseddate) {
		super();
		this.tid = tid;
		this.username = username;
		this.email = email;
		this.issue = issue;
		this.status = status;
		this.raiseddate = raiseddate;
	}
	public TicketDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
