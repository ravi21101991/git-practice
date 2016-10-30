package com.manning.spring.practice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by ravinair on 29/10/16.
 */
@Data
@AllArgsConstructor
public class Account {

	private String accountNumber;

	private BigDecimal balance;

	private Date lastPaidOn;

}
