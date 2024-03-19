package com.infinite.crm.dto;

import java.util.List;

import com.infinite.crm.model.Products;

public class Products2DTO {
	private List<Products> products1;

	private List<Products> products2;

	public List<Products> getProducts1() {
		return products1;
	}

	public void setProducts1(List<Products> products1) {
		this.products1 = products1;
	}

	public List<Products> getProducts2() {
		return products2;
	}

	public void setProducts2(List<Products> products2) {
		this.products2 = products2;
	}

	public Products2DTO(List<Products> products1, List<Products> products2) {
		super();
		this.products1 = products1;
		this.products2 = products2;
	}

	public Products2DTO() {
		super();
	}

	
}
