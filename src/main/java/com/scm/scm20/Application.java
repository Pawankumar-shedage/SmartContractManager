package com.scm.scm20;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.scm.scm20.services.EmailSenderService;

@SpringBootApplication
public class Application {

	@Autowired
	private EmailSenderService emailSenderService;

	public static void main(String[] args) {
		System.out.println("STARTED SPRINGBOOT");
		SpringApplication.run(Application.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void sendEmail() {
		emailSenderService.sendEmail("gamingnation5g@gmail.com", "Test subject: email from SCM2.0",
				"Test body: email from SCM2.0");
	}

}
