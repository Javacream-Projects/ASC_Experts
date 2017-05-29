package org.javacream.publishing.entities;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.javacream.publishing.values.BookValue;
import org.javacream.publishing.values.PriceStatistic;

public class PublishingControllerImpl implements PublishingController {

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/* (non-Javadoc)
	 * @see org.javacream.publishing.entities.PublishingController#savePublisher(org.javacream.publishing.entities.Publisher)
	 */
	@Override
	public void savePublisher(Publisher publisher){
			entityManager.persist(publisher);
	}
	
	/* (non-Javadoc)
	 * @see org.javacream.publishing.entities.PublishingController#findPublisherByName(java.lang.String)
	 */
	@Override
	public Publisher findPublisherByName(String name){
		Query query = entityManager.createQuery("select publisher from Publisher as publisher where publisher.publisherName=:name");
		query.setParameter("name", name);
		Publisher p = (Publisher) query.getSingleResult();
		
		//Trigger loading
		p.getBooks().size();
		return p;
		
	}

	/* (non-Javadoc)
	 * @see org.javacream.publishing.entities.PublishingController#addBookToPublisher(org.javacream.publishing.entities.Publisher, org.javacream.publishing.entities.Book)
	 */
	@Override
	public void addBookToPublisher(Publisher publisher, Book book){
		book.setPublisher(publisher);
	}

	/* (non-Javadoc)
	 * @see org.javacream.publishing.entities.PublishingController#findBooksForAuthor(java.lang.String)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Book> findBooksForAuthor(String authorName){

		Query query = entityManager.createQuery("select book from Book as book join book.authors as author where author.lastname=:name");
		query.setParameter("name", authorName);
		return query.getResultList();
		
	}
	
	public Book findBookByIsbn(Isbn isbn) {
		Query query = entityManager.createQuery("select book from Book as book where book.isbn = :isbn");
		query.setParameter("isbn", isbn);
		return (Book) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BookValue> findAll() {
		List<BookValue> result = entityManager.createQuery("select new org.javacream.publishing.values.BookValue(b.isbn, b.title) from Book as b").getResultList();
		return result;
	}

	@Override
	public long getBookCountForPublisher(String publisherName) {
		TypedQuery<Long> query = entityManager.createQuery("select count(b) from Book as b where b.publisher.publisherName=:name", Long.class);
		query.setParameter("name", publisherName);
		return query.getSingleResult();
	}

	@Override
	public void changePrice(double percentage) {
		Query query = entityManager.createQuery("update Book b set b.price = b.price*:percentage");
		query.setParameter("percentage", 1.0 + percentage);
		query.executeUpdate();
	
	}

	@Override
	public PriceStatistic getPriceStatisticForPublisher(String publisherName) {
		Query query  = entityManager.createQuery("select new org.javacream.publishing.values.PriceStatistic(sum(b.price), max(b.price), min(b.price), sum(b.price)/count(b))  from Book as b where b.publisher.publisherName=:name");
		query.setParameter("name", publisherName);
		return (PriceStatistic) query.getSingleResult();
	}

	public void deleteBookByIsbn(Isbn isbn){
		Book b = findBookByIsbn(isbn);
		for (Author a: b.getAuthorsSet()){
			a.getBooks().remove(b);
		}
		b.getAuthorsSet().clear();
		b.getBookInfo().setBook(null);
		b.bookInfo = null;
		b.getPublisher().getBooks().remove(b);
		b.setPublisher(null);
		entityManager.remove(b);
	}
}
