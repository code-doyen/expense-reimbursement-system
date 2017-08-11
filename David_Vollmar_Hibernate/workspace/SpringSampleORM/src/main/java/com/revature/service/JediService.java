package com.revature.service;

import java.util.List;

import com.revature.model.Jedi;

public interface JediService {
		public List<Jedi> getAllJedis();
		public void registerJedi(Jedi jedi);
		public  Jedi findJedi(Jedi jedi);
}
