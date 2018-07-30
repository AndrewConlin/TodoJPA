package com.skilldistillery.todoapp.tests;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.todoapp.entities.User;

class UserTest {
	private EntityManagerFactory emf;
	private EntityManager em;
	private User user;
	
	@BeforeEach
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("todo");
		em = emf.createEntityManager();
		user = em.find(User.class, 1);
	}

	@AfterEach
	public void tearDown() throws Exception {
		em.close();
		emf.close();
	}

	@Test
	void test() {
		assertEquals("andrew", user.getUsername());
		
	}

}
