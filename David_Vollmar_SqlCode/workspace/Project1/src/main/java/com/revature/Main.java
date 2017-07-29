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
				new Staff("username", "password", 5, "elena", "vollmar", " ", "elena@bgsu.edu", "Manager")));
		//insert_staff('david', 'vollmar', 5, 'david', 'vollmar', null, 'vollmad@bgsu.edu', 'Pro')
		//Test select all
		System.out.println(StaffService.getStaffService().listAllUsers());

		//Test login
		System.out.println(StaffService.getStaffService().login(
				new Staff("david","1234")));
	}
}
