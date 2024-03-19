package com.infinite.crm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinite.crm.exceptions.UserNotFoundException;
import com.infinite.crm.model.User;
import com.infinite.crm.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	  public User findByEmail(String email) {
		  return userRepository.findByEmail(email);
	  }
	  
	  public User findByPassword(String password) {
		  return userRepository.findByPassword(password);
	  }
	  
	  public User findByEmailAndPassword(String email, String password) {
		  return userRepository.findByEmailAndPassword(email, password);
	  }

	public User save(User newUser) {
		// TODO Auto-generated method stub
		return userRepository.save(newUser);
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	public User findById1(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
	}


	public User findById2(Long id, User newUser) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).map(user -> {
			user.setName(newUser.getName());
			user.setPassword(newUser.getPassword());
			user.setEmail(newUser.getEmail());
			user.setMobileno(newUser.getMobileno());
			return userRepository.save(user);
		}).orElseThrow(() -> new UserNotFoundException(id));
	}
	
	public User findById3(Long id, User newUser) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).map(user ->{
			user.setMobileno(newUser.getMobileno());
			return userRepository.save(user);
		}).orElseThrow(()->new UserNotFoundException(id));
	}

	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.existsById(id);
	}

	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	} 

}
