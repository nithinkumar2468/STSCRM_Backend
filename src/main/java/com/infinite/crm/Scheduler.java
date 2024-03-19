package com.infinite.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;

import com.infinite.crm.model.Ticket;
import com.infinite.crm.service.Email;

public class Scheduler {
	public void email(Ticket newT) {
		if(newT.getStatus().equalsIgnoreCase("done"))
		{
			String s=newT.getStatus();
			email(s);
			return ;
		}
		
	}
	
	@Autowired
	private Email emailService;	
	
	@Scheduled(cron="0 */2 * ? * *")
	@EventListener(ApplicationReadyEvent.class)
	public void email(String s){
		if(s.equalsIgnoreCase("done")){
			emailService.sendEmail("nithinkumarkodipaika@gmail.com", "Ticket is Pending to resolve", "Please");
		}
		else{
			emailService.sendEmail("nithinkumar0972@gmail.com", "Your Issue is Resolved..!", "Your issue has been resolved..!");
		}
	}

}

