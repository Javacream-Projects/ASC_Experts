package org.javacream.spring.training.basic.calculator.application;

import javax.annotation.PostConstruct;
import javax.swing.JFrame;

import org.javacream.spring.training.basic.calculator.api.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class CalculatorGui {

	@Value("${ui.title}")
	private String title;
	@Value("${ui.height}")
	private int height;
	@Value("${ui.width}")
	private int width;

	@Autowired
	private CalculatorService calculatorService;

	@PostConstruct
	public void initUiI() {
		System.out.println("title: " + title);
		System.out.println("calculatorService: " + calculatorService);

		JFrame frame = new JFrame(title);
		frame.setBounds(0, 0, height, width);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("application.xml");
	}
}
