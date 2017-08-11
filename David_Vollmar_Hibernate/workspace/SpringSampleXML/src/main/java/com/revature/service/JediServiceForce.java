package com.revature.service;

import java.util.List;

import com.revature.model.Jedi;
import com.revature.repository.JediRepository;

public class JediServiceForce implements JediService{
 private JediRepository jediRepository;
 	//alaways proved no args contructor
 public JediServiceForce() {}
 
 public JediServiceForce(JediRepository jediRepository) {
	 this.jediRepository = jediRepository;
 }
 


public void setJediRepository(JediRepository jediRepository) {
	this.jediRepository = jediRepository;
}

@Override
public List<Jedi> getAllJedis() {
	return jediRepository.selectAll();
}
 
}