package org.javacream.address.impl;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.javacream.address.api.Address;
import org.javacream.address.api.AddressService;
import org.javacream.address.api.AddressValidator;
import org.javacream.address.normalizer.api.Normalizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

	private Set<Address> addresses = new HashSet<>();

	@Autowired
	private AddressValidator addressValidator;
	@Autowired
	private Normalizer normalizer;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@PostConstruct public void init(){
	}
	@Override
	public boolean createAddress(String city, String street) {

		System.out.println("#########" + jdbcTemplate);
		String normalizedStreet = normalizer.normalize(street);
		String normalizedCity = normalizer.normalize(city);
		if (addressValidator.validateCity(normalizedCity) && addressValidator.validateStreet(normalizedStreet)) {
			Address address = new Address(normalizedCity, normalizedStreet);
			addresses.add(address);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isKnown(Address address) {
		return addresses.contains(address);
	}

	@Override
	public boolean removeAddress(Address address) {
		return addresses.remove(address);
	}

	@Override
	public void dump() {
		System.out.println(addresses);
	}

}
