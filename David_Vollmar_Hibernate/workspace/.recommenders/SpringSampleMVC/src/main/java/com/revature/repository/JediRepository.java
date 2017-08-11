package com.revature.repository;

import java.util.List;

import com.revature.model.Jedi;

public interface JediRepository {
	public void insert(Jedi jedi);
	public Jedi selectByName(Jedi jedi);
	public List<Jedi> selectAll();
}
