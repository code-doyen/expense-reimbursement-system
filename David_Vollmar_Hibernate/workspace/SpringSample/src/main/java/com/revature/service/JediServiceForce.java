package com.revature.service;

import java.util.List;

import com.revature.model.Jedi;
import com.revature.repository.JediRepository;
import com.revature.repository.JediRepositoryHibernate;

public class JediServiceForce implements JediService{
 private JediRepository jediRepository = new JediRepositoryHibernate();
	//always provide no args contructor
 public JediServiceForce() {}
 

@Override
public List<Jedi> getAllJedis() {
	return jediRepository.selectAll();
}
 
}
