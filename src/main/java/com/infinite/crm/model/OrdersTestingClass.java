package com.infinite.crm.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="orderstestingclass")
public class OrdersTestingClass {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int orderid;
	
	private String username;
	
	@Column(name="email")
	private String email;
	
	private String pname;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
	private LocalDate orderdate;
	
	private Long totalprice;
	
	private String address;

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
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

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public LocalDate getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(LocalDate orderdate) {
		this.orderdate = orderdate;
	}

	public Long getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(Long totalprice) {
		this.totalprice = totalprice;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public OrdersTestingClass(int orderid, String username, String email, String pname, LocalDate orderdate, Long totalprice,
			String address) {
		super();
		this.orderid = orderid;
		this.username = username;
		this.email = email;
		this.pname = pname;
		this.orderdate = orderdate;
		this.totalprice = totalprice;
		this.address = address;
	}

	public OrdersTestingClass() {
		super();
	}

	
}
