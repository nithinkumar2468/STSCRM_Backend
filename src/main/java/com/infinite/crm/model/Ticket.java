package com.infinite.crm.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ticket1")
public class Ticket {                                   // ticket pojo

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long tid;

	@Column(name = "username")
	private String username;

	@Column(name = "email")
	private String email;

	@Column(name = "issue")
	private String issue;

	@Column(name = "status")
	private String status;
	
	@Column(name = "raiseddate")
	//@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
	private String raiseddate;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="users_email")
	private User users;

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

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public Ticket(Long tid, String username, String email, String issue, String status, String raiseddate, User users) {
		super();
		this.tid = tid;
		this.username = username;
		this.email = email;
		this.issue = issue;
		this.status = status;
		this.raiseddate = raiseddate;
		this.users = users;
	}

	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}

	}
