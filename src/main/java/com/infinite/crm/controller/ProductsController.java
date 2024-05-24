package com.infinite.crm.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infinite.crm.dto.Products2DTO;
import com.infinite.crm.exceptions.UserNotFoundException;
import com.infinite.crm.model.Products;
import com.infinite.crm.service.ProductService;
import com.infinite.crm.service.Products2ServiceProxy;

@RestController
@CrossOrigin("https://master.dfhb2sx7j66q1.amplifyapp.com")
@RequestMapping("api/n1")
public class ProductsController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private Products2ServiceProxy proxy;

	@Autowired
	private ProductService productService;

	@PostMapping("/product")
	public Products newProduct(@RequestBody Products newProduct) {
		return productService.adduser(newProduct);
	}

	/*
	 * @GetMapping("/products") List<Products> getAllProducts() { return
	 * productService.productList(); }
	 */

	@GetMapping("/products")
	public List<Products2DTO> getAllProductsfrom2() {

		List<Products2DTO> dto = new ArrayList<>();
		List<Products2DTO> products1 = modelMapper.map(productService.productList(), List.class);
		dto.addAll(products1); // modelMapper.map(products1,Products2DTO.class);
		List<Products2DTO> response = modelMapper.map(proxy.getAllProducts(), List.class);
		//logger.info("{}", response); // dto.setProducts2(response);
		dto.addAll(response); // modelMapper.map(response,Products2DTO.class);
		return dto;
	}

	@GetMapping("/product/{id}")
	public Products getProductById(@PathVariable Long id) {
		Products product = null;
		if (productService.exist(id)) {
			product = productService.productById(id);
		} else {
			product = proxy.getProductById(id);
		}
		return product;
	}

	/*
	 * @GetMapping("/product/{id}") public Products getProductById(@PathVariable
	 * Long id) { 
	 * return productService.productById(id); 
	 * }
	 */

	@PutMapping("/product/{id}")
	Products updateUser(@RequestBody Products newProduct, @PathVariable Long id) {
		return productService.findById(id, newProduct);
	}

	@DeleteMapping("/product/{id}")
	String deleteProduct(@PathVariable Long id) {
		if (!productService.exist(id)) {
			throw new UserNotFoundException(id);
		}
		productService.delete(id);
		return "Product with id " + id + " has been deleted successfully..!";
	}
}
