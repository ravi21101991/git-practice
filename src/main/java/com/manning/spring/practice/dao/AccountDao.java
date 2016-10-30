package com.manning.spring.practice.dao;

import com.manning.spring.practice.domain.Account;

import java.util.List;

/**
 * Created by ravinair on 29/10/16.
 */
public interface AccountDao {

	List<Account> findAll();
}
