package com.manning.spring.practice.service.impl;

import com.manning.spring.practice.dao.AccountDao;
import com.manning.spring.practice.domain.Account;
import com.manning.spring.practice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ravinair on 29/10/16.
 */

@Service("accountService")
@Scope(value = "singleton")
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;

	@Override
	public List<Account> findDeliquentAccounts() {
		return accountDao
				.findAll()
				.stream()
				.filter(account -> isLegitAccount(account))
				.collect(Collectors.toList());
	}

	private boolean isLegitAccount(Account account) {
		boolean hasMoney = BigDecimal.ZERO.compareTo(account.getBalance()) <= 0;
		boolean isLate = getDateBeforeDays(-30).after(account.getLastPaidOn());
		return hasMoney && isLate;
	}

	private Date getDateBeforeDays(int days) {
		Date today = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(today.getTime());
		calendar.add(Calendar.DATE, days);
		return calendar.getTime();
	}
}
