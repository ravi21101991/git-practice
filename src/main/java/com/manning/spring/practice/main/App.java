package com.manning.spring.practice.main;

import com.manning.spring.practice.domain.Contact;
import com.manning.spring.practice.service.AccountService;
import com.manning.spring.practice.service.ContactService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ravinair on 29/10/16.
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		AccountService accountService = (AccountService) context.getBean("accountService");
		accountService.findDeliquentAccounts().forEach(System.out::println);
		ContactService contactService = (ContactService)context.getBean("contactService");
		contactService.create(new Contact("Dhara", "Nair", "dhara@gmail.com"));
		contactService.findAll().forEach(Contact::printInfo);
	}
}
