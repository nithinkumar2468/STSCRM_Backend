package com.infinite.crm.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinite.crm.dto.OrdersDTO;
import com.infinite.crm.model.Orders;
import com.infinite.crm.model.User;
import com.infinite.crm.repository.OrdersRepository;
import com.infinite.crm.repository.UserRepository;

@Service
public class OrdersService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private OrdersRepository repo;

	@Autowired
	private ModelMapper modelMapper;

	public Orders addOrders(String useremail, OrdersDTO newOrders) {
		User email = userRepo.findByEmail(useremail);
		Orders newO = new Orders();
		newO.setUsers(email);
		newO.setPname(newOrders.getPname());
		newO.setAddress(newOrders.getAddress());
		newO.setTotalprice(newOrders.getTotalprice());
		newO.setOrdereddate(newOrders.getOrdereddate());
		return repo.save(newO);
	}

	public List<OrdersDTO> findAllOrders(String useremail) {
		User email = userRepo.findByEmail(useremail);

		List<Orders> orders = repo.findAllByUsersEmail(useremail);

		return orders.stream().map(order -> modelMapper.map(order, OrdersDTO.class)).collect(Collectors.toList());
	}

}
