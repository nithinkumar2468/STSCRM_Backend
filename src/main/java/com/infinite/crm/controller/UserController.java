package com.infinite.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infinite.crm.exceptions.UserNotFoundException;
import com.infinite.crm.model.LoginFront;
import com.infinite.crm.model.LoginMessage;
import com.infinite.crm.model.User;
import com.infinite.crm.service.Email;
import com.infinite.crm.service.UserService;

@RestController
@CrossOrigin("https://master.dfhb2sx7j66q1.amplifyapp.com")
@RequestMapping("api/n1")
public class UserController {

	private String loginlink = "https://master.dfhb2sx7j66q1.amplifyapp.com/login1";

	private String adminEmail = "helpdesk.crm.capstone@gmail.com";

	@Autowired
	private Email emailService;

	@Autowired
	private UserService userService;

	@PostMapping("/user")
	User newUser(@RequestBody User newUser) {

		emailService.sendEmail(newUser.getEmail(), " Welcome to CRM App - Your Registration Was Successful!", "Hi "
				+ newUser.getName() + "," + '\n' + '\n' + "Welcome to CRM!" + '\n' + '\n'
				+ "Your registration was successful, and you're now a part of our organization." + '\n' + '\n'
				+ "Here are some quick steps to get you started:" + '\n' + "1. Log in to Your Account: " + loginlink
				+ '\n'
				+ "2. Explore Features: Check out our [Getting Started Guide] to learn about the powerful features we offer."
				+ '\n' + '\n' + "If you need any help, our support team is here for you. You can reach us at "
				+ adminEmail + " or visit our [Customer Care] for FAQs and guides." + '\n' + '\n' + "Best regards,"
				+ '\n' + "CRM App");

		return userService.save(newUser);
	}

	@PostMapping(path = "/users/login")
	LoginMessage loginuser(@RequestBody LoginFront loginFront) {
		User email = userService.findByEmail(loginFront.getEmail());
		if (email != null) {
			String password = loginFront.getPassword();
			String userpass = email.getPassword();
			if (password.matches(userpass)) {
				return new LoginMessage("Login Success", true);
			} else {
				return new LoginMessage("Incorrect emailId or Password", false);
			}
		} else {
			return new LoginMessage("emailId not exist", false);
		}
	}

	@GetMapping("/users")
	List<User> getAllUsers() {
		return userService.findAll();

	}

	@GetMapping("/user/{id}")
	User getUserById(@PathVariable Long id) {
		return userService.findById1(id);
	}

	/*
	 * @PutMapping("/user/{id}") User updateUser(@RequestBody User
	 * newUser, @PathVariable Long id) { return userService.findById2(id,newUser); }
	 */

	@PatchMapping("/user/{id}")
	User updateUserMobileno(@RequestBody User newUser, @PathVariable Long id) {
		return userService.findById3(id, newUser);
	}

	@DeleteMapping("/user/{id}")
	String deleteUser(@PathVariable Long id) {
		if (!userService.existsById(id)) {
			throw new UserNotFoundException(id);
		}
		userService.deleteById(id);
		return "User with id " + id + " has been deleted success..!";
	}
}
