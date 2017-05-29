package org.javacream.demo.jpa;

public class CatUtil {

	public static void simulateCatDiet(Cat c){
		c.setWeight(c.getWeight() * 0.9);
	}
}
