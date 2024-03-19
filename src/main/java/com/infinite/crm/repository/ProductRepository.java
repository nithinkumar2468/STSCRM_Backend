package com.infinite.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infinite.crm.model.Products;



public interface ProductRepository extends JpaRepository<Products,Long>{

}
