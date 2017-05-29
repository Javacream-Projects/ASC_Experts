package org.javacream.demo.jpa;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

public class JpaTest {

	
	@Test public void testJpaEnvironment(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
		EntityManager em = emf.createEntityManager();
		System.out.println("EntityManager: " + em);
	}

	@Test public void testJpaSql(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		String sql = "create table messages (col_message varchar(256), col_message2 varchar(256))";
		em.createNativeQuery(sql).executeUpdate();
		sql = "insert into messages values ('Hello', 'World')";
		em.createNativeQuery(sql).executeUpdate();
		sql = "select * from messages";
		List<Object[]> result = em.createNativeQuery(sql).getResultList();
		transaction.commit();
		System.out.println(result.get(0)[0] + ":" + result.get(0)[1]);
		em.close();
	}

	@Test public void testJpaObjects(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		System.out.println("EntityManager: " + em);
		Cat cat1 = new Cat("Thommy", 5.5, "brown");
		
		em.persist(cat1);
		transaction.commit();
		//Search by primary key
		Cat searchResult = em.find(Cat.class, 1l);
		searchResult = em.createQuery("select cat from CatEntity as cat where cat.name = 'Thommy'", Cat.class).getSingleResult();
		searchResult =(Cat) em.createNativeQuery("select * from CATS where name = 'Thommy'", Cat.class).getSingleResult();
		System.out.println(searchResult);
		transaction.begin();
		em.remove(searchResult);
		transaction.commit();
		
	}

	
}
