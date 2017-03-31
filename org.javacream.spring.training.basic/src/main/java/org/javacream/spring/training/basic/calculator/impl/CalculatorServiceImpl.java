package org.javacream.spring.training.basic.calculator.impl;

import org.javacream.spring.training.basic.calculator.api.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javacream.Util;

@Service
public class CalculatorServiceImpl implements CalculatorService {

	@Autowired
	private Util util;
	
	
	@Override
	public double circleArea(double radius) {
		return radius * radius * Math.PI;
	}

	@Override
	public double circlePerimeter(double radius) {
		System.out.println(util.execute());
		return 2 * radius * Math.PI;
	}

}
