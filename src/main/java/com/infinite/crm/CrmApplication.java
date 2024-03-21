package com.infinite.crm;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.infinite.crm.model.Ticket;
import com.infinite.crm.service.Email;

@SpringBootApplication
@EnableScheduling
@EnableFeignClients("com.infinite.crm")
@EnableDiscoveryClient
public class CrmApplication {
	
	
	@Autowired
	private Email emailService;

	public static void main(String[] args) {
		SpringApplication.run(CrmApplication.class, args);
	}

	public void email(Ticket newT) {
		if (newT.getStatus().equalsIgnoreCase("done")) {
			email();
		} else {
			mailtouser();
		}
	}

	
	@Scheduled(cron = "0 */2 * ? * *")
	@EventListener(ApplicationReadyEvent.class)
	public void email() {
		emailService.sendEmail("nithinkumarkodipaika@gmail.com", "Ticket is Pending to resolve",
				"Please Resolve the ticket..!");
	}

	@Scheduled(cron = "0 */2 * ? * *")
	@EventListener(ApplicationReadyEvent.class)
	public void mailtouser() {
		emailService.sendEmail("nithinkumar0972@gmail.com", "Your Issue is Resolved..!",
				"Your issue has been resolved..!");
	}
	
	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
