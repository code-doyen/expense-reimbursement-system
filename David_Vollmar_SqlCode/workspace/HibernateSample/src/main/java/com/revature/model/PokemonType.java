package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="POKEMON_TYPE")
public class PokemonType {
	
	@Id
	@GeneratedValue
	//@Column(name="PT_NAME")
	//private String name;
	@Column(name="PT_ID")
	private int id;
	@Column(name="PT_TYPE")
	private String type;
	
	public PokemonType(){}

	public PokemonType(int id, String type) {
		super();
//		this.name = name;
		this.id = id;
		this.type = type;
	}

	public PokemonType(String type) {
		this.type = type;
	}
//
//	public void setName(String name) {
//		this.name = name;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "PokemonType [id=" + id + ", type=" + type + "]";
	}
	
}
