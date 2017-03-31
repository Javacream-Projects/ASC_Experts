package com.javacream;

public class Util {

	private String name;

	public Util(String name){
		this.name = name;
	}
	
	public void init(){
		name = new StringBuilder(name).reverse().toString();
		
	}
	
	public String execute(){
		return name;
	}
}
