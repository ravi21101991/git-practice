package com.manning.spring.practice.service.impl;

import com.manning.spring.practice.domain.Contact;
import com.manning.spring.practice.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ravinair on 30/10/16.
 */
@Service("contactService")
public class ContactServiceImpl implements ContactService {

	private static final String CREATE_SQL = "INSERT INTO contacts (first_name, last_name, email) VALUES (:firstName, :lastName, :email)";

	private static final String FIND_ALL_SQL = "SELECT * FROM contacts";

	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public void create(Contact contact) {
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
				.addValue("firstName", contact.getFirstName())
				.addValue("lastName", contact.getLastName())
				.addValue("email", contact.getEmail());
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(CREATE_SQL, sqlParameterSource, keyHolder);
		contact.setId(keyHolder.getKey().longValue());
	}

	@Override
	public List<Contact> findAll() {
		return jdbcTemplate.query(FIND_ALL_SQL, ((resultSet, i) ->
				new Contact(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4))));
	}
}
