package com.infinite.crm.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infinite.crm.exceptions.UserNotFoundException;
import com.infinite.crm.model.Ticket;
import com.infinite.crm.model.TicketDTO;
import com.infinite.crm.service.TicketService;


@RestController
@CrossOrigin("http://localhost:3000")
public class TicketsController {

	@Autowired
	private TicketService ticketService;
	
	@PostMapping("/{useremail}/ticket")
	Ticket newTicket(@PathVariable String useremail,@RequestBody TicketDTO newTicket) {
		
		LocalDateTime myDateObj = LocalDateTime.now();   
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm a");  
	    
	    String formattedDate = myDateObj.format(myFormatObj);  
	    
	    newTicket.setRaiseddate(formattedDate);
	    
		return ticketService.addTicket(useremail,newTicket);
	}
	
	@GetMapping("/{useremail}/tickets")
	List<TicketDTO> getAllTicketsbyemail(@PathVariable String useremail) {
		return ticketService.findAllTickets(useremail);
	}
	
	@GetMapping("/tickets")
	List<TicketDTO> getAllTickets() {
		return ticketService.findAllTicketsforAdmin();
	}
	
	/*
	 * @GetMapping("/{useremail}/ticket/{tid}") TicketDTO
	 * getTicketById(@PathVariable String useremail,@PathVariable Long tid) throws
	 * Exception { return ticketService.findTicketById(useremail,tid); }
	 */
	
	@GetMapping("/ticket/{tid}")
	TicketDTO getTicketById(@PathVariable Long tid) throws Exception {
		return ticketService.findTicketById(tid);
	}

	@PutMapping("/ticket/{tid}")
	TicketDTO updateTicket(@RequestBody TicketDTO newTicket, @PathVariable Long tid) {
		return ticketService.updateTicket(tid,newTicket);
	}

	@DeleteMapping("/ticket/{tid}")
	String deleteTicket(@PathVariable Long tid) {
		if (!ticketService.exist(tid)) {
			throw new UserNotFoundException(tid);
		}
		ticketService.deleteTicket(tid);
		return "User with id " + tid + " has been deleted success.";
	}
}
