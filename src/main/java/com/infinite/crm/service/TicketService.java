package com.infinite.crm.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinite.crm.exceptions.UserNotFoundException;
import com.infinite.crm.model.AdminTickets;
import com.infinite.crm.model.Ticket;
import com.infinite.crm.model.TicketDTO;
import com.infinite.crm.model.User;
import com.infinite.crm.repository.TicketRepository;
import com.infinite.crm.repository.UserRepository;

@Service
public class TicketService {

	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	/*
	 * public Ticket addTicket(Ticket newTicket) { return
	 * ticketRepository.save(newTicket); }
	 */	
	public Ticket addTicket(String useremail, TicketDTO newTicket) {
		// TODO Auto-generated method stub
		User email=userRepo.findByEmail(useremail);
		Ticket newT=new Ticket();
		newT.setUsers(email);
		newT.setUsername(newTicket.getUsername());
		newT.setEmail(newTicket.getEmail());
		newT.setIssue(newTicket.getIssue());
		newT.setStatus(newTicket.getStatus());
		newT.setRaiseddate(newTicket.getRaiseddate());
		return ticketRepository.save(newT);
	};

	/*
	 * public List<Ticket> findTicket() { return ticketRepository.findAll(); }
	 */
	
	public List<TicketDTO> findAllTickets(String useremail) {
		// TODO Auto-generated method stub
        User email=userRepo.findByEmail(useremail);
		
		List<Ticket> tickets=ticketRepository.findAllByUsersEmail(useremail);
		
		return tickets.stream().map(ticket -> modelMapper.map(ticket, TicketDTO.class)).collect(Collectors.toList());
	}

	/*
	 * public Ticket findTicket(Long tid) { // TODO Auto-generated method stub
	 * return ticketRepository.findById(tid).orElseThrow(() -> new
	 * UserNotFoundException(tid)); }
	 */

	/*
	 * public TicketDTO findTicketById(String useremail, Long tid) throws Exception
	 * { // TODO Auto-generated method stub User
	 * email=userRepo.findByEmail(useremail);
	 * 
	 * Ticket ticket=ticketRepository.findById(tid).get();
	 * 
	 * if(email.getId()!=ticket.getUsers().getId()) { throw new
	 * Exception("Ticket Not Found"); } return modelMapper.map(ticket,
	 * TicketDTO.class); }
	 */
	
	public TicketDTO findTicketById(Long tid) {
		// TODO Auto-generated method stub
		return modelMapper.map(ticketRepository.findById(tid).get(),TicketDTO.class);
	}

	public TicketDTO updateTicket(Long tid, TicketDTO newTicket) {
		// TODO Auto-generated method stub
		return modelMapper.map(ticketRepository.findById(tid).map(ticket -> {
			ticket.setUsername(newTicket.getUsername());
			ticket.setEmail(newTicket.getEmail());
			ticket.setIssue(newTicket.getIssue());
			ticket.setStatus(newTicket.getStatus());
			return ticketRepository.save(ticket);
		}).orElseThrow(() -> new UserNotFoundException(tid)),TicketDTO.class);
	}

	public boolean exist(Long tid) {
		// TODO Auto-generated method stub
		return ticketRepository.existsById(tid);

	}

	public void deleteTicket(Long tid) {
		// TODO Auto-generated method stub
		ticketRepository.deleteById(tid);
	}

	public List<TicketDTO> findAllTicketsforAdmin() {
		// TODO Auto-generated method stub
		
		List<Ticket> tickets=ticketRepository.findAll();
		
		return tickets.stream().map(ticket -> modelMapper.map(ticket, TicketDTO.class)).collect(Collectors.toList());
	}
}
