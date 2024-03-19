package com.infinite.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infinite.crm.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

	User findByPassword(String password);

	User findByEmailAndPassword(String email, String password);

}
