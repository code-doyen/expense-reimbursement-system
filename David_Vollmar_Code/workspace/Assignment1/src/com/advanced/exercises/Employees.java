package com.advanced.exercises;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
public class Employees{
	public String name;
	public Integer age;
	public String department;
	public Employees(String name, Integer age, String department) {
		super();
		this.name = name;
		this.age = age;
		this.department = department;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public static void main(String[] args){
		// TODO Auto-generated method stub
		List<Employees> list= new ArrayList<>();
		list.add(new Employees("David", 36, "Software Development"));
		list.add(new Employees("Leah", 26, "Model"));
		list.add(new Employees("Cat", 21, "Actress"));
		//Sorting by age
		SortedSet<Employees> ageSet = new TreeSet<>(new EmployeeAgeComparator());
		ageSet.addAll(list);
		//System.out.println(ageSet);
		//Sorting by age
		SortedSet<Employees> nameSet = new TreeSet<>(new EmployeeNameComparator());
		nameSet.addAll(list);
		//System.out.println(nameSet);
		//Sorting by age
		SortedSet<Employees> departmentSet = new TreeSet<>(new EmployeeDepartmentComparator());
		departmentSet.addAll(list);
		//System.out.println(departmentSet);
		Employees t = null;
		System.out.println("Sorted by age");
		Iterator<Employees> i = ageSet.iterator();
		while(i.hasNext()){
			t = i.next();
			System.out.println(t.getName()+", "+t.getAge()+", "+t.getDepartment());
		}
		System.out.println("\nSorted by name");
		Iterator<Employees> ii = nameSet.iterator();
		while(ii.hasNext()){
			t = ii.next();
			System.out.println(t.getName()+", "+t.getAge()+", "+t.getDepartment());
		}
		System.out.println("\nSorted by department");
		Iterator<Employees> iii = departmentSet.iterator();
		while(iii.hasNext()){
			t = iii.next();
			System.out.println(t.getName()+", "+t.getAge()+", "+t.getDepartment());
		}
	}
	
}
