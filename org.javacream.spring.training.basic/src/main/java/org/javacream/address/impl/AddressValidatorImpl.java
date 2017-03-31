package org.javacream.address.impl;

import java.util.Set;

import org.javacream.address.api.AddressValidator;
import org.springframework.stereotype.Service;

@Service
public class AddressValidatorImpl implements AddressValidator {

	private Set<String> validCities;
	
	
	public void setValidCities(Set<String> validCities) {
		this.validCities = validCities;
	}

	@Override
	public boolean validateStreet(String street) {
		return true;
	}

	@Override
	public boolean validateCity(String city) {
		return validCities.contains(city);
	}

}
