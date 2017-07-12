package com.revature.day5.designpatterns;

public class CreationPattern {

	private static CreationPattern instance;
	
	private CreationPattern() {
		
	}
	
	public static CreationPattern getInstance(){
		if (instance ==null){
			instance = new CreationPattern();
		}
		return instance;
	}
}
