package com.revature.dao;

import static org.hibernate.criterion.Restrictions.eq;
import org.hibernate.Session;

import com.revature.model.PokemonType;
import com.revature.util.HibernateUtil;

public class PokemonTypeDaoHibernate implements PokemonTypeDao{

	@Override
	public void insert(PokemonType pokemonType) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(pokemonType);
		//session.getTransaction();
		session.getTransaction().commit();
	}

	@Override
	public PokemonType select(PokemonType pokemonType) {
		// TODO Auto-generated method stub
		try{
			return (PokemonType) HibernateUtil.getSession().createCriteria(PokemonType.class).add(eq("type", pokemonType.getType()))
			.list().get(0);
			
		}catch(IndexOutOfBoundsException e){
			return new PokemonType();
		}
	}
	
	
	

}
