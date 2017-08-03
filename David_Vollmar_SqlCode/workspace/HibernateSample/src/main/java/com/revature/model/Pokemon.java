package com.revature.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="POKEMON",
uniqueConstraints ={@UniqueConstraint(columnNames={"P_NAME"}) })
public class Pokemon {
	
	@Id
	@GeneratedValue
	@Column(name="P_ID")
	private int id;
	@Column(name="P_NAME")
	private String name;
	@Column(name="P_NUMBER")
	private int number;
	@OneToOne(fetch=FetchType.EAGER)
	private PokemonType type;
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private Pokemon evolution;
	
	public Pokemon(){}
	
	public Pokemon(String name){this.name =name;}

	public Pokemon(int id, String name, int number, PokemonType type, Pokemon evolution) {
		this.id = id;
		this.name = name;
		this.number = number;
		this.type = type;
		this.evolution = evolution;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public PokemonType getType() {
		return type;
	}

	public void setType(PokemonType type) {
		this.type = type;
	}

	public Pokemon getEvolution() {
		return evolution;
	}

	public void setEvolution(Pokemon evolution) {
		this.evolution = evolution;
	}

	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", name=" + name + ", number=" + number + ", type=" + type + ", evolution="
				+ evolution + "]";
	}
	
}
