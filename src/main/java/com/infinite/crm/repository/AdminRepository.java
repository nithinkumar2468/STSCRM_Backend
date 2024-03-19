package com.infinite.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infinite.crm.model.Admin;



public interface AdminRepository extends JpaRepository<Admin,Long>{
	
	Admin findByEmail(String email);

	Admin findByPassword(String password);

	Admin findByEmailAndPassword(String email, String password);

}
