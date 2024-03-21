package com.infinite.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinite.crm.model.OrdersTestingClass;
import com.infinite.crm.repository.OrderTestingRepository;

@Service
public class OrdersTestingService {
	
	@Autowired
	private OrderTestingRepository Repo;

	public OrdersTestingClass addOrders(OrdersTestingClass newOrder) {
		return Repo.save(newOrder);
	}

	public List<OrdersTestingClass> findOrders() {
		return Repo.findAll();
	}

	public OrdersTestingClass findOrderbyId(int id) {
		return Repo.findById(id).get();
	}

	public OrdersTestingClass updateOrder(int id, OrdersTestingClass newOrder) {
		return Repo.findById(id).map(order->{
			order.setPname(newOrder.getPname());
			order.setAddress(newOrder.getAddress());
			order.setUsername(newOrder.getUsername());
			order.setEmail(newOrder.getEmail());
			order.setOrderdate(newOrder.getOrderdate());
			order.setTotalprice(newOrder.getTotalprice());
			return Repo.save(order);
		}).get();
				
		}
}
