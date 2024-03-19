package com.infinite.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinite.crm.exceptions.UserNotFoundException;
import com.infinite.crm.model.Products;
import com.infinite.crm.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;

	public Products adduser(Products newProduct) {
		// TODO Auto-generated method stub
		return productRepository.save(newProduct);
	}

	public List<Products> productList() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	public Object findproduct(Long id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id);
	}

	public boolean exist(Long id) {
		// TODO Auto-generated method stub
		return productRepository.existsById(id);
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
	}

	public Products findById(Long id,Products newProduct) {
		// TODO Auto-generated method stub
		return productRepository.findById(id).map(product -> {
			product.setPname(newProduct.getPname());
			product.setRating(newProduct.getRating());
			product.setPrice(newProduct.getPrice());
			product.setBrand(newProduct.getBrand());
			return productRepository.save(product);
		}).orElseThrow(() -> new UserNotFoundException(id));
	}

	public Products productById(Long id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
	}

}
