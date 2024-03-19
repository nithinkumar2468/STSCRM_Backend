package com.infinite.crm.service;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.infinite.crm.model.Products;

@FeignClient(name = "products2")
@RibbonClient(name="products2")
public interface Products2ServiceProxy {

	@GetMapping("/products2")
	List<Products> getAllProducts();
	
	@GetMapping("/product2/{id}")
	public Products getProductById(@PathVariable Long id);
}
