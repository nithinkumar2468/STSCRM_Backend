package com.infinite.crm.dto;

public class OrdersDTO {
	
	private Long orderid;
	private String pname;
	private String totalprice;
    private String address;
	private String ordereddate;
	public OrdersDTO() {
		super();
	}
	public OrdersDTO(Long orderid, String pname, String totalprice, String address, String ordereddate) {
		super();
		this.orderid = orderid;
		this.pname = pname;
		this.totalprice = totalprice;
		this.address = address;
		this.ordereddate = ordereddate;
	}
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

}
