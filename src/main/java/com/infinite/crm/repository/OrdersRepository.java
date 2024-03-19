package com.infinite.crm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infinite.crm.model.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders,Long>{

	List<Orders> findAllByUsersEmail(String useremail);

}
