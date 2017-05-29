package org.javacream.publishing.values;

public class BookInfo {

	private String isbn;
	private String title;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		BookInfo other = (BookInfo) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	public BookInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookInfo(String isbn, String title, double price) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.price = price;
	}
	@Override
	public String toString() {
		return "BookValue [isbn=" + isbn + ", title=" + title + ", price="
				+ price + ", toString()=" + super.toString() + "]";
	}
	public String getIsbn() {
		return isbn;
	}
	public String getTitle() {
		return title;
	}
	
	private double price;
	public double getPrice() {
		return price;
	}
}
