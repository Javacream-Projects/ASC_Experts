package org.javacream.publishing.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityManager;

import org.javacream.publishing.entities.Author;
import org.javacream.publishing.entities.Book;
import org.javacream.publishing.entities.BookStatistics;
import org.javacream.publishing.entities.Isbn;
import org.javacream.publishing.entities.JpaPublishingController;
import org.javacream.publishing.entities.Publisher;
import org.javacream.publishing.entities.PublishingController;
import org.javacream.util.Address;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PublishingTest {
	private PublishingController publishingController;
	private EntityManager entityManager;

	@Before
	public void createController() throws Exception {
		JpaPublishingController jpaPublishingController = new JpaPublishingController();
		entityManager = jpaPublishingController.getEntityManager();

		publishingController = jpaPublishingController;
	}

	@Test
	public void insertPublishers() {
		int publisherSize = 4;
		int booksSize = 40;
		int authorsSize = 3;

		List<String> keywords1 = Arrays.asList(new String[] { "sports",
				"socker" });
		List<String> keywords2 = Arrays.asList(new String[] {
				"science fiction", "star trek", "enterprise" });

		Author[] authors = new Author[authorsSize];
		for (int i = 0; i < authorsSize; i++) {
			Author author = new Author();
			ArrayList<String> givenNames = new ArrayList<String>(3);
			for (int j = 0; j < 3; j++) {
				givenNames.add("GivenName" + i + "_" + j);
			}
			author.setGivenNames(givenNames);
			author.setLastname("AuthorLastname" + (i + 1));
			authors[i] = author;
		}

		Publisher[] publishers = new Publisher[publisherSize];
		for (int i = 0; i < publisherSize; i++) {
			HashSet<Book> books = new HashSet<Book>();
			Publisher publisher = new Publisher("Publisher" + (i + 1), books,
					new Address("Publisher-City" + i, "Publisher-Street" + i));
			publishers[i] = publisher;

			for (int j = 0; j < booksSize; j++) {
				Book book = new Book("a simple book", new Isbn(i, j, 3, 4),
						200 + j, 9.95 * j, "book" + i + j, new BookStatistics(50 * j,
								new Date()), false);
				if (j % 2 == 0) {
					authors[0].addBook(book);
				}
				if (i % 2 == 0) {
					authors[1].addBook(book);
				}
				if ((i + j) % 2 == 0) {
					authors[2].addBook(book);
				}
				if (i % 2 == 0) {
					book.setKeywords(keywords1);
				} else {
					book.setKeywords(keywords2);
				}
				publisher.addBooks(book);

			}

			publishingController.savePublisher(publisher);
		}

		entityManager.clear();
		System.out.println(entityManager.contains(publishers[1]));
		Publisher p = publishingController.findPublisherByName("Publisher1");
		// entityManager.close();
		Assert.assertNotNull(p);
		System.out.println("Publisher: " + p);
		for (Book book : p.getBooks()) {
			System.out.println("\tBook: " + book);
		}
		entityManager.clear();
		Book book = (Book) entityManager.createQuery(
				"select book from Book as book where book.title = 'book11'")
				.getSingleResult();
		System.out.println(book.getTitle());

		entityManager.clear();
		p = entityManager.find(Publisher.class, 3l);
		Book b = entityManager.find(Book.class, 42l);
		publishingController.addBookToPublisher(p, b);
		entityManager.clear();
		p = entityManager.getReference(Publisher.class, 3l);
		b = entityManager.getReference(Book.class, 43l);
		publishingController.addBookToPublisher(p, b);

		System.out.println(publishingController
				.findBooksForAuthor("AuthorLastname1"));
	}
}
