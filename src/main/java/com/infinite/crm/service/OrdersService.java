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

	@Autowired
	private Email emailService;

	public Orders addOrders(String useremail, OrdersDTO newOrders) {
		User email = userRepo.findByEmail(useremail);
		Orders newO = new Orders();
		newO.setUsers(email);
		newO.setPname(newOrders.getPname());
		newO.setAddress(newOrders.getAddress());
		newO.setTotalprice(newOrders.getTotalprice());
		newO.setOrdereddate(newOrders.getOrdereddate());

		User userdetails = userRepo.findByEmail(useremail);

		emailService.sendEmail(useremail, "Your Order Confirmation - Thank You for Your Purchase!", "Hi "
				+ userdetails.getName() + "," + '\n' + '\n' + "Thank you for your order! " + '\n' + '\n'
				+ "We’re excited to let you know that we’ve received your order and it’s now being processed. Below are the details of your purchase:"
				+ '\n' + '\n' 
				+ "Order Number: " + newOrders.getOrderid() + '\n' 
				+ "Order Date: "+ newOrders.getOrdereddate() + '\n' + '\n' 
				+ "Total Amount: "+newOrders.getTotalprice()
				+ "We will notify you once your order has been shipped. If you have any questions or need further assistance, please visit our [Customer Care] for FAQs and guides.\r\n"
				+ "\r\n"
				+ "Thank you for shopping with us!\r\n"
				+ "\r\n"
				+ "Best regards,"+'\n'
				+ "CRM App");
		return repo.save(newO);
	}

	public List<OrdersDTO> findAllOrders(String useremail) {
		User email = userRepo.findByEmail(useremail);

		List<Orders> orders = repo.findAllByUsersEmail(useremail);

		return orders.stream().map(order -> modelMapper.map(order, OrdersDTO.class)).collect(Collectors.toList());
	}

}
