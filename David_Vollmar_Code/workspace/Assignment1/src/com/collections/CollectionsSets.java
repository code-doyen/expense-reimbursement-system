package com.collections;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class CollectionsSets {
	public static void main(String[] args) {
		// Array list
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(9);
		list.add(3);
		Iterator<Integer> i = list.iterator();
		System.out.println("Array list Original");
		while(i.hasNext())
			System.out.println(i.next());
		System.out.println("Array list Sorted");
		Collections.sort(list);
		i = list.iterator();
		while(i.hasNext())
			System.out.println(i.next());
		
		
		// LinkedList
		List<Integer> ll = new LinkedList<>();
		ll.add(4);
		ll.add(50);
		ll.add(6);
		Iterator<Integer> ii = ll.iterator();
		System.out.println("LinkedList Original");
		while(ii.hasNext())
			System.out.println(ii.next());
		System.out.println("LinkedList Sorted");
		Collections.sort(ll);
		ii = ll.iterator();
		while(ii.hasNext())
			System.out.println(ii.next());
		
		
		
		//HashMap //transform into a sorted map (hierarchy) -> treemap
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(10, "David");
		hm.put(9, "Leah");
		hm.put(5, "Sydney");
		Set<Integer> keys = hm.keySet();
		System.out.println("HashMap Original");
		for(Integer key: keys){
			System.out.println("Value of "+key+" is: " + hm.get(key));
		}
		System.out.println("HashMap Sorted");
		Map<Integer, String> hmsorted = new TreeMap<>(hm);
		// iterate acc to ascending order of keys
		for(Integer strkey : hmsorted.keySet()){
			System.out.println("Value of "+strkey+" is: " + hmsorted.get(strkey));
		}
		
		
		//TreeSet sorts self
		Set<Integer> ts = new TreeSet<Integer>(); 
		ts.add(30);
		ts.add(7);
		ts.add(5);
		Iterator<Integer> iii = ts.iterator();
		System.out.println("TreeSet Original");
		while(iii.hasNext())
			System.out.println(iii.next());
		System.out.println("TreeSet Sorted");
		Set<Integer> tsorted = new TreeSet<Integer>(ts); // creates a sorted hashset 
		iii = tsorted.iterator();
		while(iii.hasNext())
			System.out.println(iii.next());
		
		
		//HashSet
		Set<Integer> hs = new HashSet<>();
		hs.add(6);
		hs.add(70);
		hs.add(8);
		Iterator<Integer> iv = hs.iterator();
		System.out.println("HashSet Original");
		while(iv.hasNext())
			System.out.println(iv.next());
		System.out.println("HashSet Sorted");
		Set<Integer> hsorted = new TreeSet<Integer>(hs); // creates a sorted hashset 
		iv = hsorted.iterator();
		while(iv.hasNext())
			System.out.println(iv.next());
	}

}
