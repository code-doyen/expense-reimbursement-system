package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.revature.model.Jedi;

@Repository("jediRepository")
public class JediRepositoryHibernate implements JediRepository {

	//Needs to be provided
	public JediRepositoryHibernate() {
		System.out.println("Instantiating Hibernate Repository Bean.");
	}
	
	@Override
	public List<Jedi> selectAll() {
		List<Jedi> jedis = new ArrayList<>();
		jedis.add(new Jedi(1,"Obi Wan","Blue"));
		jedis.add(new Jedi(2,"Yoda","Green"));
		
		return jedis;
	}

}
