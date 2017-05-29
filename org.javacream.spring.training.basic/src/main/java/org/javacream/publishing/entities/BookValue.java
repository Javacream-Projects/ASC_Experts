package org.javacream.publishing.entities;

import java.io.Serializable;


/**
 * The persistent class for the BOOK database table.
 * 
 */
public class BookValue implements Serializable {
	private static final long serialVersionUID = 1L;

	private long id;

	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ", pages=" + pages
				+ ", price=" + price + ", title=" + title + ", available="
				+ available + ", toString()=" + super.toString() + "]";
	}

	private String isbn;

	private int pages;

	private double price;

	private String title;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookValue other = (BookValue) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}

	
	private boolean available;
    public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	BookValue() {
    }

	public long getId() {
		return this.id;
	}

	public String getIsbn() {
		return this.isbn;
	}


	public BookValue(String isbn, String title, int pages, double price,
			boolean available) {
		super();
		this.isbn = isbn;
		this.pages = pages;
		this.price = price;
		this.title = title;
		this.available = available;
	}

	public int getPages() {
		return this.pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
}