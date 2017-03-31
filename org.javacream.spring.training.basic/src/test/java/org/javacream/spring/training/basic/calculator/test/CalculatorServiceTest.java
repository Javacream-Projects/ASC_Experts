package org.javacream.spring.training.basic.calculator.test;

import org.javacream.spring.training.basic.calculator.api.CalculatorService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class CalculatorServiceTest {
	
	@Autowired
	private CalculatorService calculatorService;
	@Test public void testPerimeterCalculation(){
		double radius = 3;
		double expectedPerimeter = 18.849;
		
		double calculatedPerimeter = calculatorService.circlePerimeter(radius);
		
		Assert.assertEquals(expectedPerimeter, calculatedPerimeter, 1e-3);
	}

}
