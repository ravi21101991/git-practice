package com.manning.spring.practice.dao.impl;

import com.manning.spring.practice.dao.AccountDao;
import com.manning.spring.practice.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ravinair on 29/10/16.
 */
@Repository("accountDao")
public class CsvAccountDaoImpl implements AccountDao {

	@Autowired
	private ResourceLoader csvResourceLoader;

	public List<Account> findAll() {
		List<Account> accounts = new ArrayList<>();
		try {
			BufferedReader bufferedReader = new BufferedReader(
					new FileReader(csvResourceLoader.getResource("accounts.csv").getFile()));
			String record;
			while ((record = bufferedReader.readLine()) != null) {
				String[] attributes = record.split(",");
				String accountNumber = attributes[0];
				BigDecimal balance = new BigDecimal(attributes[1]);
				DateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
				Date lastPaidOn = dateFormat.parse(attributes[2]);
				accounts.add(new Account(accountNumber, balance, lastPaidOn));
			}

		}
		catch (IOException | ParseException exception) {

		}
		return accounts;
	}
}
