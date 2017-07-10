package com.revature.day4.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CollectionsSample {
	
	public List<Integer> arrayListSample() {
		List<Integer> list = new ArrayList<>();
		list.add(7);
		list.add(2);
		list.add(2);
		list.add(1);
		list.add(5);
		list.add(6);
		
		return list;
	}
	
	public Set<Integer> hashSetSample() {
		Set<Integer> set = new HashSet<>();
		set.add(7);
		set.add(2);
		set.add(2);
		set.add(1);
		set.add(5);
		set.add(6);
		set.add(100);
		set.add(45);
		return set;
		//return new HashSet<>(this.arrayListSample());
	}
	
	public static void main(String[] args) {
		//I accept repeated values
		List<Integer> list = new CollectionsSample().arrayListSample();
		System.out.println(list);
		
		//I DON'T accept repeated values
		Set<Integer> set = new CollectionsSample().hashSetSample();
		System.out.println(set);
		
		//Looping
		for(Integer i: list) {
			//System.out.println(i);
		}
		
		for(int i = 0; i < list.size(); i++) {
			//System.out.println(list.get(i));
		}
		
		Iterator<Integer> i = list.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
	}
	
	
	
	

}
