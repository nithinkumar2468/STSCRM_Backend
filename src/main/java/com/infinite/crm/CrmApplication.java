package com.infinite.crm;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.infinite.crm.model.Admin;
import com.infinite.crm.model.Ticket;
import com.infinite.crm.model.User;
import com.infinite.crm.repository.AdminRepository;
import com.infinite.crm.repository.TicketRepository;
import com.infinite.crm.repository.UserRepository;
import com.infinite.crm.service.Email;

@SpringBootApplication
@EnableScheduling
@EnableFeignClients("com.infinite.crm")
//@EnableDiscoveryClient
public class CrmApplication {

	@Autowired
	private Email emailService;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private TicketRepository ticketRepo;

	@Autowired
	private AdminRepository adminRepo;

	public static void main(String[] args) {
		SpringApplication.run(CrmApplication.class, args);
	}

	@Scheduled(cron = "0 */2 * ? * *")
	public void emailScheduler() {
		List<Ticket> tickets = ticketRepo.findAll();

		for (Ticket ticket : tickets) {
			if (ticket.getStatus().equalsIgnoreCase("active")) {
				List<Admin> admins = adminRepo.findAll();
				List<String> adminEmails = admins.stream().map(Admin::getEmail).collect(Collectors.toList());
				emailService.sendEmailToMultipleRecipients(adminEmails,
						"Ticket is Pending to resolve -- " + ticket.getTid(),
						"Dear admin ," + '\n' + "Please Resolve the issue regarding " + ticket.getIssue() + " on "
								+ ticket.getRaiseddate() + " by the mail-Id: " + ticket.getEmail() + '\n' + '\n'
								+ "Regards," + '\n' + "capstone-crm");
			}
		}
	}

	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
