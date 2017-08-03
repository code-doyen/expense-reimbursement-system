package com.revature.dao;

import static org.hibernate.criterion.Restrictions.eq;

import java.util.List;

import org.hibernate.Session;

import com.revature.model.Pokemon;
import com.revature.model.PokemonType;
import com.revature.util.HibernateUtil;

public class PokemonDaoHibernate implements PokemonDao {

	@Override
	public void insert(Pokemon pokemon) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(pokemon);
		//session.getTransaction();
		session.getTransaction().commit();
	}

	@Override
	public Pokemon select(Pokemon pokemon) {
		// TODO Auto-generated method stub
		try{
			return (Pokemon) HibernateUtil.getSession().createCriteria(Pokemon.class).add(eq("type", pokemon.getName()))
			.list().get(0);
			
		}catch(IndexOutOfBoundsException e){
			return new Pokemon();
		}
	}

	@Override
	public List<Pokemon> selectAll() {
		// TODO Auto-generated method stub
		return HibernateUtil.getSession().createCriteria(Pokemon.class).list();
		
	}

}
