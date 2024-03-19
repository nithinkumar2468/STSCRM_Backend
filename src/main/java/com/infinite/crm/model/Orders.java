package com.infinite.crm.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
@SequenceGenerator(name="order_id_seq", initialValue=2000)
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="order_id_seq")
	private Long orderid;

	@Column(name = "pname")
	private String pname;

	@Column(name = "totalprice")
	private String totalprice;

	@Column(name = "address")
	private String address;
	
	@Column(name = "ordereddate")
	private String ordereddate;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="users_email")
	private User users;

	public Long getOrderid() {
		return orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(String totalprice) {
		this.totalprice = totalprice;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOrdereddate() {
		return ordereddate;
	}

	public void setOrdereddate(String ordereddate) {
		this.ordereddate = ordereddate;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public Orders(Long orderid, String pname, String totalprice, String address, String ordereddate, User users) {
		super();
		this.orderid = orderid;
		this.pname = pname;
		this.totalprice = totalprice;
		this.address = address;
		this.ordereddate = ordereddate;
		this.users = users;
	}

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
}
