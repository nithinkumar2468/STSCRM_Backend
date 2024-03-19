package com.infinite.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinite.crm.model.Admin;
import com.infinite.crm.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	public Admin findByEmail(String email) {
		return adminRepository.findByEmail(email);
	}

	public Admin findByPassword(String password) {
		return adminRepository.findByPassword(password);
	}

	Admin findByEmailAndPassword(String email, String password) {
		return adminRepository.findByEmailAndPassword(email, password);
	}

}
