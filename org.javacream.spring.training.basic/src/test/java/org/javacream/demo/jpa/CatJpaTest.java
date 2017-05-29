package org.javacream.demo.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

public class CatJpaTest {

	
	@Test public void testCat(){
		//DROP CREATE in persistence.xml
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Cat cat = new Cat("Thommy" + System.currentTimeMillis(), 3.99);
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(cat);
		Query query = entityManager.createQuery("select cat from Cat as cat");
		System.out.println(query.getResultList());
		transaction.commit();
		entityManager.close();
		//entityManagerFactory.close(); //DROP
	
	}
}
