package org.javacream.address.test;

import org.javacream.address.api.AddressValidator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class AddressValidatorTest {
	
	@Autowired
	private AddressValidator addressValidator;

	@Test public void testValidCity(){
		Assert.assertTrue(addressValidator.validateCity("BERLIN"));
	}
	@Test public void testInValidCity(){
		Assert.assertFalse(addressValidator.validateCity("BÖRLIN"));
	}
	@Test public void testValidStreet(){
		Assert.assertTrue(addressValidator.validateStreet("egal"));
	}

}
