package com.advanced.exercises;

import java.util.Comparator;

public class EmployeeNameComparator implements Comparator<Employees> {
	
	@Override
	public int compare(Employees arg0, Employees arg1) {
		// TODO Auto-generated method stub
		return arg0.getName().compareTo(arg1.getName());
	}
}
