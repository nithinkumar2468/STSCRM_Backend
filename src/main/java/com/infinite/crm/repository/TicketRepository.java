package com.infinite.crm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infinite.crm.model.Ticket;


@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long>{

	List<Ticket> findAllByUsersEmail(String useremail);

}
