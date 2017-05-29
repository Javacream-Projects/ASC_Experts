package org.javacream.publishing;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.javacream.publishing.values.BookInfo;

public class BooksReportGenerator {


	public void reportWithBookInfo()
	{
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("JPA");
		EntityManager entityManager = fac.createEntityManager();
		Query query = entityManager.createNativeQuery("select isbn, title, price from BOOKS", BookInfo.class);
		@SuppressWarnings("unchecked")
		List<BookInfo> result = query.getResultList();
		System.out.println("ISBN\tTITLE\tPRICE");
		for (BookInfo row: result){
			System.out.println(String.format("%s\t%s\t%.2f", row.getIsbn(), row.getTitle(), row.getPrice()));
		}
		entityManager.close();
		fac.close();
	}

	public void reportWithObjectArray()
	{
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("JPA");
		EntityManager entityManager = fac.createEntityManager();
		Query query = entityManager.createNativeQuery("select isbn, title, price from BOOKS");
		@SuppressWarnings("unchecked")
		List<Object[]> result = query.getResultList();
		System.out.println("ISBN\tTITLE\tPRICE");
		for (Object[] row: result){
			System.out.println(String.format("%s\t%s\t%.2f", row));
		}
		entityManager.close();
		fac.close();
	}
	
	{
		reportWithObjectArray();
		reportWithBookInfo();
	}
	public static void main(String[] args) {
		new BooksReportGenerator();
	}
}
