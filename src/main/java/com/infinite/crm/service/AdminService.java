package com.infinite.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinite.crm.model.Admin;
import com.infinite.crm.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	/*
	 * @Autowired private PasswordEncoder Encoder;
	 */
	
	public Admin findByEmail(String email) {
		return adminRepository.findByEmail(email);
	}

	public Admin findByPassword(String password) {
		return adminRepository.findByPassword(password);
	}

	Admin findByEmailAndPassword(String email, String password) {
		return adminRepository.findByEmailAndPassword(email, password);
	}

	/*
	 * public Admin saveAdmin(AdminDTO admindto) { // TODO Auto-generated method
	 * stub Admin admin=new Admin(); admin.setEmail(admindto.getEmail());
	 * admin.setPassword(Encoder.encode(admindto.getPassword())); return
	 * adminRepository.save(admin); }
	 */

}
