package com.revature.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Jedi;

/* 
 * Transactional Jedi Repository.
 * When we get sessions from the factory, these are our contextual sessions.
 * Also: Check little red thing on each method (left), STS recognizes a method is being adviced (AOP).
 * */
@Repository("jediRepository")
@Transactional
public class JediRepositoryHibernate implements JediRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	/* Needs to be provided */
	public JediRepositoryHibernate() {
		System.out.println("Instantiating Hibernate Repository Bean.");
	}
	
	@Override
	public void insert(Jedi jedi) {
		sessionFactory.getCurrentSession().save(jedi);
	}

	@Override
	public Jedi selectByName(Jedi jedi) {
		try {
			return (Jedi) sessionFactory.getCurrentSession().createCriteria(Jedi.class)
			.add(Restrictions.like("name", jedi.getName()))
			.list()
			.get(0);
		}
		catch (IndexOutOfBoundsException e) {
			return new Jedi();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Jedi> selectAll() {
		return sessionFactory.getCurrentSession().createCriteria(Jedi.class).list();
	}

	
}
