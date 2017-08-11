package com.revature.service;

import java.util.List;

import com.revature.model.Jedi;

public interface JediService {
	public void register(Jedi jedi);
	public Jedi getJedi(Jedi jedi);
	public List<Jedi> getAllJedis();
}
