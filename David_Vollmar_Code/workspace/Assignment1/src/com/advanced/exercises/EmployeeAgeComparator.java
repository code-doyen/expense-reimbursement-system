package com.advanced.exercises;

import java.util.Comparator;

public class EmployeeAgeComparator implements Comparator<Employees>{

	@Override
	public int compare(Employees o1, Employees o2) {
		// TODO Auto-generated method stub
		return o1.getAge().compareTo(o2.getAge());
	}
}
