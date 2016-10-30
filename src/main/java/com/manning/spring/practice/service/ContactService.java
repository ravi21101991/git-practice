package com.manning.spring.practice.service;

import com.manning.spring.practice.domain.Contact;

import java.util.List;

/**
 * Created by ravinair on 30/10/16.
 */
public interface ContactService {

	void create(Contact contact);

	List<Contact> findAll();
}
