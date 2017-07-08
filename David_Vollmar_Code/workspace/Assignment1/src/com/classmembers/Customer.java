package com.classmembers;

public class Customer {
	static int id = 1;
	final int year = 2017;
	String nameFirst;
	String nameLast;
	String location;
	String contact;
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public Customer(String firstName, String lastName, String address, String phone){
		++id;	
		nameFirst = firstName;
		nameLast = lastName;
		location = address;
		contact = phone;
	}
	public static void setClientContacts(String address){
		
	}
	public static void setClientContacts(String address, String phone){
		
	}
	public static void setClientName(String firstName){
		
	}
	public static void setClientName(String firstName, String lastName){
		
	}
}
