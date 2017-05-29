package org.javacream.address.test;

import org.javacream.address.api.Address;
import org.javacream.address.api.AddressService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class AddressServiceTest {
	
	@Autowired
	private AddressService addressService;
	@Autowired
//	private JdbcTemplate jdbcTemplate;
//	@Before public void init(){
//		jdbcTemplate.execute(new StatementCallback<String>() {
//
//			@Override
//			public String doInStatement(Statement statement) throws SQLException, DataAccessException {
//				try{
//				statement.executeUpdate("create table egal  (col_message varchar(255))");
//				}
//				catch(SQLException e){
//					//OK, Tabelle existiert
//				}
//				return "OK";
//			}
//		});
//
//	}
	@Test public void createAddresses(){
		Assert.assertTrue(addressService.createAddress("München", "Marienplatz"));
		Assert.assertFalse(addressService.createAddress("Mönchen", "Marienplatz"));
		Assert.assertTrue(addressService.createAddress("Berlin", "Alex-ander_PlatZ"));
		addressService.dump();
		
	}
	@Test public void knownAddresses(){
		Assert.assertTrue(addressService.createAddress("München", "Marien_Plat-z"));
		Address address = new Address("MÜNCHEN", "MARIENPLATZ");
		Assert.assertTrue(addressService.isKnown(address));
		Address address2 = new Address("MÜNCHEN", "KARLSPLATZ");
		Assert.assertFalse(addressService.isKnown(address2));
	}
	@Test public void removeAddress(){
		Assert.assertTrue(addressService.createAddress("München", "Marien_Plat-z"));
		Address address = new Address("MÜNCHEN", "MARIENPLATZ");
		Assert.assertTrue(addressService.removeAddress(address));
		Assert.assertFalse(addressService.removeAddress(address));
	}

}
