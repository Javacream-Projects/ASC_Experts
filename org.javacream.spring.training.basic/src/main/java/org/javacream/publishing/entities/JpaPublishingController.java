package org.javacream.publishing.entities;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.javacream.publishing.values.BookValue;
import org.javacream.publishing.values.PriceStatistic;

public class JpaPublishingController implements PublishingController {

	public EntityManager getEntityManager() {
		return entityManager;
	}

	private PublishingControllerImpl impl;

	public List<BookValue> findAll() {
		return impl.findAll();
	}

	public long getBookCountForPublisher(String publisherName) {
		return impl.getBookCountForPublisher(publisherName);
	}

	public void changePrice(double percentage) {
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			impl.changePrice(percentage);
		} catch (RuntimeException e) {
			transaction.rollback();
			throw e;
		}
	}

	public PriceStatistic getPriceStatisticForPublisher(String publisherName) {
		return impl.getPriceStatisticForPublisher(publisherName);
	}

	public void savePublisher(Publisher publisher) {
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			impl.savePublisher(publisher);
			transaction.commit();
		} catch (RuntimeException e) {
			transaction.rollback();
			throw e;
		}

	}

	public Publisher findPublisherByName(String name) {
		return impl.findPublisherByName(name);
	}

	public Book findBookByIsbn(Isbn isbn) {
		return impl.findBookByIsbn(isbn);
	}

	public void addBookToPublisher(Publisher publisher, Book book) {
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			impl.addBookToPublisher(publisher, book);
			transaction.commit();
		} catch (RuntimeException e) {
			transaction.rollback();
			throw e;
		}
	}

	public List<Book> findBooksForAuthor(String authorName) {
		return impl.findBooksForAuthor(authorName);
	}

	private EntityManager entityManager;

	{
		impl = new PublishingControllerImpl();
		entityManager = Persistence.createEntityManagerFactory("JPA")
				.createEntityManager();
		impl.setEntityManager(entityManager);

	}

}
