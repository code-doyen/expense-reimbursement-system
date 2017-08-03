package com.revature;

import com.revature.dao.PokemonDao;
import com.revature.dao.PokemonDaoHibernate;
import com.revature.dao.PokemonTypeDao;
import com.revature.dao.PokemonTypeDaoHibernate;
import com.revature.model.Pokemon;
import com.revature.model.PokemonType;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PokemonTypeDao pokemonTypeDao = new PokemonTypeDaoHibernate();
		PokemonDao pokemonDao = new PokemonDaoHibernate();
		
		pokemonTypeDao.insert(new PokemonType(0, "GRASS"));
		pokemonTypeDao.insert(new PokemonType(0, "FIRE"));
		pokemonTypeDao.insert(new PokemonType(0, "WATER"));
		
		System.out.println(pokemonTypeDao.select(new PokemonType("GRASS")));
		
		pokemonDao.insert(new Pokemon(0, "BULBASAUR", 1,  pokemonTypeDao.select(new PokemonType("GRASS")), 
				new Pokemon(0, "IVYSAUR", 2,  pokemonTypeDao.select(new PokemonType("GRASS")),
				new Pokemon(0, "VENASAUR", 3,  pokemonTypeDao.select(new PokemonType("GRASS")),null)) ));
		
		System.out.println(pokemonDao.select(new Pokemon("IVYSAUR")));
		System.out.println(pokemonDao.select(new Pokemon("BULBASAUR")));
		
		
		System.out.println(pokemonDao.selectAll());
		
		//lazy load
		Pokemon bulbasaur = pokemonDao.select(new Pokemon("BULBASAUR"));
		System.out.println("I have not asked for evolution");
		System.out.println(bulbasaur.getEvolution());
		System.out.println("I have asked for evolution");
	}

}
