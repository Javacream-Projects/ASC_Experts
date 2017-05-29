package org.javacream.publishing.entities;

public class BookUtil {

	public static double simulateDiscount(Book ... books){
		for (Book b: books){
			b.setPrice(b.getPrice()* 0.85);
		}
		
		return bookTotalPrice(books);
		
		
	}
	
	public static double bookTotalPrice(Book ... books){
		double totalPrice = 0;
		for (Book b: books){
			totalPrice += b.getPrice();
		}
		return totalPrice;
		
	}
}
