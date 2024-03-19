package com.infinite.crm.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infinite.crm.model.OrdersTestingClass;
import com.infinite.crm.service.OrdersTestingService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("api/n1")
public class OrdersTestingController {
	
	@Autowired
	private OrdersTestingService service;
	
	
	@PostMapping("/orderstesting")
	OrdersTestingClass newOrders(@RequestBody OrdersTestingClass newOrder) {
		LocalDate date = LocalDate.now();
		newOrder.setOrderdate(date);
		return service.addOrders(newOrder);
	}

	@GetMapping("/orderstesting")
	List<OrdersTestingClass> getAllOrders() {
		return service.findOrders();
	}

	@GetMapping("/ordertesting/{id}")
	OrdersTestingClass getOrdersById(@PathVariable int id) {
		return service.findOrderbyId(id);
	}

	@PutMapping("/ordertesting/{id}")
	OrdersTestingClass updateOrders(@RequestBody OrdersTestingClass newOrder, @PathVariable int id) {
		return service.updateOrder(id,newOrder);
	}

}
