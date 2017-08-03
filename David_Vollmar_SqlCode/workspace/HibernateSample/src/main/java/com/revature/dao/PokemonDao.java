package com.revature.dao;

import java.util.List;

import com.revature.model.Pokemon;

public interface PokemonDao {
	public void insert(Pokemon pokemon);
	public List<Pokemon> selectAll();
	public Pokemon select(Pokemon pokemon);
}
