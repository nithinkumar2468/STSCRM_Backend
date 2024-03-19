package com.infinite.crm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infinite.crm.model.UserAddress;

@Repository
public interface UserAddressRepository extends JpaRepository<UserAddress,Long>{

	List<UserAddress> findAllByUsersEmail(String useremail);

}
