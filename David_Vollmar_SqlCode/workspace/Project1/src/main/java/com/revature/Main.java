package com.revature;

import com.revature.model.Staff;
import com.revature.service.StaffService;

/* Welcome to the Java */
public class Main {
	public static void main(String[] args) {
		//Test insert
		//System.out.println(StaffService.getStaffService().registerStaff(
		//		new Staff(0,"Peter","Alagna","petronilo","1234")));
		
		//Test insert procedure
		System.out.println(StaffService.getStaffService().registerStaffSecure(
				new Staff("username", "password", 4, "elena", "vollmar", null, "elena@bgsu.edu", "Manager")));
		
		//insert_staff("username", "password", , "elena", "vollmar", null || phone, "elena@bgsu.edu", "Manager")
		//Test select all
		System.out.println(StaffService.getStaffService().listAllUsers());

		//Test login
		System.out.println(StaffService.getStaffService().login(
				new Staff("david","vollmar")));
	}
}
