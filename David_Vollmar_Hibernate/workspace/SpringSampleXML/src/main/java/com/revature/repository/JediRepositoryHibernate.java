package com.revature.repository;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Jedi;

public class JediRepositoryHibernate implements JediRepository {
	
	public JediRepositoryHibernate(){
		System.out.println("instaciating jedi repo");
	}
	public List<Jedi> selectAll() {
		List<Jedi> jedis = new ArrayList<>();
		
		jedis.add(new Jedi(1, "Yoda", "Green"));
		jedis.add(new Jedi(1, "Anakin", "Blue"));
		jedis.add(new Jedi(1, "Obi Wan Kanobi", "Blue"));
		
		
		return jedis;
	}

}
