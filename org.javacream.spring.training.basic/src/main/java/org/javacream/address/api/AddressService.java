package org.javacream.address.api;

public interface AddressService {

	boolean createAddress(String city, String street);
	boolean isKnown(Address address);
	boolean removeAddress(Address address);
	void dump();
}
