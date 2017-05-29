package org.javacream.demo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.Session;
import org.junit.Test;

public class CatJpaTest {

	
	@Test public void testCat(){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		
		Cat cat = new Cat("Thommy" + System.currentTimeMillis(), 3.99, "brown");
		transaction.begin();
		System.out.println("Before persist: " + cat);
		entityManager.persist(cat);
		System.out.println("After persist: " + cat);

		cat.setWeight(6.99);
		transaction.commit();
		//entityManager.detach(cat);
		//TypedQuery<Cat> query = entityManager.createQuery("select cat from CatEntity as cat", Cat.class);
		Query query = entityManager.createNativeQuery("select * from CATS",Cat.class);
		Query query2 = entityManager.createNativeQuery("select * from CATS");
		Cat searchResult = (Cat) query.getResultList().get(0);
		List<Object> searchResult2 = query.getResultList(); 
		cat.setWeight(7.99);
		searchResult.setFurColor("red");
		System.out.println(cat.getFurColor());
		System.out.println(cat == searchResult);
		transaction.begin();
		transaction.commit();
		
		System.out.println(entityManager.createQuery("select cat from CatEntity as cat", Cat.class).getResultList());
		
		entityManager.clear();
		Cat attachedCat = entityManager.merge(cat);
		entityManager.close();
	
	}
	
	@Test public void testHibernate(){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Session session = (Session) entityManager.getDelegate();
//		session.re
	
	}
}
