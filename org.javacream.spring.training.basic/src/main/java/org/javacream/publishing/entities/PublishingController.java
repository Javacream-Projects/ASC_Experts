package org.javacream.publishing.entities;

import java.util.List;

import org.javacream.publishing.values.BookValue;
import org.javacream.publishing.values.PriceStatistic;

public interface PublishingController {

	public abstract void savePublisher(Publisher publisher);

	public abstract Publisher findPublisherByName(String name);

	public abstract Book findBookByIsbn(Isbn isbn);

	public abstract void addBookToPublisher(Publisher publisher, Book book);

	public abstract List<Book> findBooksForAuthor(String authorName);

	List<BookValue> findAll();
	
	long getBookCountForPublisher(String publisherName);
	
	void changePrice(double percentage);
	
	PriceStatistic getPriceStatisticForPublisher(String publisherName);
	
}