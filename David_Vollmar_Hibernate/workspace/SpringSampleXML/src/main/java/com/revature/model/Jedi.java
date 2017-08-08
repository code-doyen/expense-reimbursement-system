package com.revature.model;

public class Jedi {
	private int id;
	private String name;
	private String saberColor;
	
	public Jedi(){}

	public Jedi(int id, String name, String saberColor) {
		super();
		this.id = id;
		this.name = name;
		this.saberColor = saberColor;
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

	public String getSaberColor() {
		return saberColor;
	}

	public void setSaberColor(String saberColor) {
		this.saberColor = saberColor;
	}

	@Override
	public String toString() {
		return "Jedi [id=" + id + ", name=" + name + ", saberColor=" + saberColor + "]";
	}
	
}
