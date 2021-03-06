package com.skilldistillery.todoapp.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.todoapp.entities.Todo;

class TodoTest {
	private EntityManagerFactory emf;
	private EntityManager em;
	private Todo todo;
	
	@BeforeEach
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("todo");
		em = emf.createEntityManager();
		todo = em.find(Todo.class, 11);
	}

	@AfterEach
	public void tearDown() throws Exception {
		em.close();
		emf.close();
	}
	@Test
	void test() {
		assertEquals("Go round mums", todo.getTask());
	}

}
