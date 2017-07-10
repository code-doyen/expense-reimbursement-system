package com.revature.day4.collections;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;

public class MapsSample {
	
	public static void main(String[] args) {
		Map<Integer,String> hashMap = new HashMap<>();
		hashMap.put(1, "Justin");
		//hashMap.put(null, "Peter");
		hashMap.put(2, "Peter");
		hashMap.put(3, "Trevin");
		hashMap.put(4, "Yuvi");
		
		//If key is the same, replace value
		hashMap.put(5, null);
		hashMap.put(5, "Jordan");
		
		//I only care about one null key
		//I don't care about null values
		System.out.println(hashMap);
		
		Map<Integer,String> hashTable = new Hashtable<>(hashMap); // Error here if nulls
		//I don't like nulls
		System.out.println(hashTable);
		
		//Iterate
		for(Integer k: hashMap.keySet()) {
			//System.out.println(hashMap.get(k));
		}
		
		for(String s: hashMap.values()) {
			//System.out.println(s);
		}
		
		//Most efficient way *******
		for(Entry<Integer,String> e: hashMap.entrySet()) {
			System.out.println(e.getKey() + " = " + e.getValue());
		}
	}
}
