package org.javacream.address.api;

public interface AddressValidator {
	boolean validateStreet(String street);

	boolean validateCity(String city);
}
