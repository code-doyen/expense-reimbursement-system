package com.revature.day4.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Hat implements Comparable<Hat> {
	private String style; 	//Natural order
	private String color;
	private String size;
	
	public Hat() {
		this.style = "";
		this.color = "";
		this.size = "";
	}
	
	public Hat(String style, String color, String size) {
		this.style = style;
		this.color = color;
		this.size = size;
	}

	public String getStyle() {
		return style;
	}
	
	public void setStyle(String style) {
		this.style = style;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getSize() {
		return size;
	}
	
	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Hat [style=" + style + ", color=" + color + ", size=" + size + "]";
	}

	@Override
	public int compareTo(Hat h) {
		return this.style.compareTo(h.style);
	}
	
	public static void main(String[] args) {
		List<Hat> list = new ArrayList<>();
		list.add(new Hat("Fedora","Black","M"));
		list.add(new Hat("Fedora","Red","L"));
		list.add(new Hat("Top","Red","S"));
		list.add(new Hat("Baseball","Blue","L"));
		list.add(new Hat("Tricorn","Green","S"));
		
		//DIFFERENT THAN COLLECTION INTERFACE
		Collections.sort(list);
		//I don't care about repeated values.
		System.out.println(list);
		
		SortedSet<Hat> set = new TreeSet<>(list);
		//I do care about repeated sorting attributes.
		System.out.println(set);
		
		//Sorting by color
		SortedSet<Hat> colorSet = new TreeSet<>(new HatColorComparator());
		colorSet.addAll(list);
		System.out.println(colorSet);
	}
}
