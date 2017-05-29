package org.javacream.publishing.values;

import org.javacream.publishing.entities.Isbn;

public class BookValue {

	private Isbn isbn;
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
	public BookValue() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookValue(Isbn isbn, String title) {
		super();
		this.isbn = isbn;
		this.title = title;
	}
	@Override
	public String toString() {
		return "BookValue [isbn=" + isbn + ", title=" + title + "]";
	}
	public Isbn getIsbn() {
		return isbn;
	}
	public String getTitle() {
		return title;
	}
}
