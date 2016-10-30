package com.manning.spring.practice.domain;

import lombok.Data;

/**
 * Created by ravinair on 30/10/16.
 */
@Data
public class Contact {

	private Long id;

	private String firstName;

	private String lastName;

	private String email;

	public Contact(Long id, String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.id = id;
	}

	public Contact(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public void printInfo(){
		System.out.println(id + " " + firstName + " " + lastName);
	}
}
