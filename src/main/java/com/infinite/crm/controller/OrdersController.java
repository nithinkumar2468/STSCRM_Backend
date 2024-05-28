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
import com.infinite.crm.service.Email;
import com.infinite.crm.service.OrdersService;

@RestController
@CrossOrigin("https://master.dfhb2sx7j66q1.amplifyapp.com")
@RequestMapping("api/n1")
public class OrdersController {
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private OrdersService service;
	
	@Autowired
	private Email emailService;
	
	@PostMapping("/{useremail}/order")
	Orders newOrders(@PathVariable String useremail,@RequestBody OrdersDTO newOrders) {
		
		LocalDateTime myDateObj = LocalDateTime.now();   
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm a");  
	    
	    String formattedDate = myDateObj.format(myFormatObj);  
	    
	    newOrders.setOrdereddate(formattedDate);
	    
	    logger.info("Users Email is :"+useremail);
	    
	    emailService.sendEmail(useremail,"Orders Placed Successfuly..!" ,"Thanks for your Order" );

		return service.addOrders(useremail,newOrders);
	}
	
	@GetMapping("/{useremail}/orders")
	List<OrdersDTO> getAllOrdersbyemail(@PathVariable String useremail) {
		return service.findAllOrders(useremail);
	}

}
