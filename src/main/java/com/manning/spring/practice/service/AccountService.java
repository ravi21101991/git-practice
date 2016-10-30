package com.manning.spring.practice.service;

import com.manning.spring.practice.domain.Account;

import java.util.List;

/**
 * Created by ravinair on 29/10/16.
 */
public interface AccountService {

	List<Account> findDeliquentAccounts();
}
