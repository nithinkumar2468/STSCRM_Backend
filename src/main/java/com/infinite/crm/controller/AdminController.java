package com.infinite.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infinite.crm.model.Admin;
import com.infinite.crm.model.LoginMessage;
import com.infinite.crm.service.AdminService;



@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("api/n2")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping(path = "/admin/login")
	public LoginMessage loginadmin(@RequestBody Admin admin) {
		Admin email = adminService.findByEmail(admin.getEmail());
		if (email != null) {
			String password = admin.getPassword();
			String userpass = email.getPassword();
			if (password.matches(userpass)) {
				return new LoginMessage("Login Success", true);
			} else 
			{
				return new LoginMessage("Incorrect admin email or Password", false);
			}
		} else {
			return new LoginMessage("adminname not exist", false);
		}
	}

}
