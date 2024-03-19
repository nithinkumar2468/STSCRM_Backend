package com.infinite.crm.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinite.crm.model.User;
import com.infinite.crm.model.UserAddress;
import com.infinite.crm.model.UserAddressDTO;
import com.infinite.crm.repository.UserAddressRepository;
import com.infinite.crm.repository.UserRepository;

@Service
public class UserAddressService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserAddressRepository repo;
	
	@Autowired
	private UserRepository userRepo;
	
	
	/*
	 * public Task saveTasks(long userid, TaskDTO taskDto) { // TODO Auto-generated
	 * method stub Users Id = userRepo.findById(userid).orElseThrow(() -> new
	 * UserNotFoundException(userid)); Task task = new Task();
	 * task.setTaskname(taskDto.getTaskname()); task.setUsers(Id); return
	 * taskRepo.save(task); }
	 */
	
	/*
	 * public UserAddress saveAddress(UserAddress newUser) { // TODO Auto-generated
	 * method stub return repo.save(newUser); }
	 */	
	
	public UserAddress saveAddress(String useremail, UserAddressDTO newUser) {
		// TODO Auto-generated method stub
		User email=userRepo.findByEmail(useremail);
		UserAddress address=new UserAddress();
		address.setUsers(email);
		address.setName(newUser.getName());
		address.setNumber(newUser.getNumber());
		address.setPincode(newUser.getPincode());
		address.setArea(newUser.getArea());
		address.setLandmark(newUser.getLandmark());
		address.setState(newUser.getState());
		address.setCountry(newUser.getCountry());
		return repo.save(address);
	}
	
	
	/*
	 * public List<TaskDTO> getAllTasks(long userid) { // TODO Auto-generated method
	 * stub 
	 * Users Id = userRepo.findById(userid).orElseThrow(() -> new
	 * UserNotFoundException(userid));
	 * 
	 * List<Task> tasks = taskRepo.findAllByUsersId(userid);
	 * 
	 * return tasks.stream().map(task -> modelMapper.map(task,
	 * TaskDTO.class)).collect(Collectors.toList()); }
	 */
	
	public List<UserAddressDTO> findAllAddresses(String useremail) {
		// TODO Auto-generated method stub
		User email=userRepo.findByEmail(useremail);
		
		List<UserAddress> addresses=repo.findAllByUsersEmail(useremail);
		
		return addresses.stream().map(task -> modelMapper.map(task, UserAddressDTO.class)).collect(Collectors.toList());
	}
	
		
	
	
	/*
	 * public List<UserAddress> findAllAdresses() { // TODO Auto-generated method
	 * stub return repo.findAll(); }
	 */

	

	public void deleteAddress(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	public UserAddress getuseraddressbyid(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}
	
}
