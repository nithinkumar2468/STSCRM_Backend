package com.infinite.crm.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infinite.crm.dto.OrdersDTO;
import com.infinite.crm.model.Orders;
import com.infinite.crm.model.User;
import com.infinite.crm.repository.UserRepository;
import com.infinite.crm.service.Email;
import com.infinite.crm.service.OrdersService;

@RestController
@CrossOrigin("https://master.dfhb2sx7j66q1.amplifyapp.com")
@RequestMapping("api/n1")
public class OrdersController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private OrdersService service;

	@Autowired
	private Email emailService;

	@Autowired
	private UserRepository repo;

	@PostMapping("/{useremail}/order")
	Orders newOrders(@PathVariable String useremail, @RequestBody OrdersDTO newOrders) {

		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm a");

		String formattedDate = myDateObj.format(myFormatObj);

		newOrders.setOrdereddate(formattedDate);

		logger.info("Users Email is :" + useremail);

		User userdetails = repo.findByEmail(useremail);

		logger.info(userdetails.getName());

		emailService.sendEmail(useremail, "Your Order Confirmation - Thank You for Your Purchase!", "Hi "
				+ userdetails.getName() + "," + '\n' + '\n' + "Thank you for your order! " + '\n' + '\n'
				+ "We’re excited to let you know that we’ve received your order and it’s now being processed. Below are the details of your purchase:");

		return service.addOrders(useremail, newOrders);
	}

	@GetMapping("/{useremail}/orders")
	List<OrdersDTO> getAllOrdersbyemail(@PathVariable String useremail) {
		return service.findAllOrders(useremail);
	}

}
