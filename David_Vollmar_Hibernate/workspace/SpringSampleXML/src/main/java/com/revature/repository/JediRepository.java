package com.revature.repository;

import java.util.List;

import com.revature.model.Jedi;

public interface JediRepository {
	
	public List<Jedi> selectAll();
}
