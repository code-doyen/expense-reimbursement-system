package com.revature.day5.fileio;

import java.io.Serializable;

public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	private int employeeID = 100;
	private String employeeName = "Tom";
	private transient int empSsn = 1234567890;
	private String empTitle = "Software Developer" ;
	
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public int getEmpSsn() {
		return empSsn;
	}
	public void setEmpSsn(int empSsn) {
		this.empSsn = empSsn;
	}
	public String getEmpTitle() {
		return empTitle;
	}
	public void setEmpTitle(String empTitle) {
		this.empTitle = empTitle;
	}
	
	
}
