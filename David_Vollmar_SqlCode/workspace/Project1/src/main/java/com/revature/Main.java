package com.revature;

import com.revature.model.Staff;
import com.revature.service.StaffService;
import com.revature.model.Reimbursement;
import com.revature.service.ReimbursementService;

/* Welcome to the Java */
public class Main {
	public static void main(String[] args) {
		//Test insert
		//System.out.println(StaffService.getStaffService().registerStaff(
		//		new Staff(0,"Peter","Alagna","petronilo","1234")));
		
		//Test insert procedure
//		System.out.println(StaffService.getStaffService().registerStaffSecure(
//				new Staff("username", "password", 4, "elena", "vollmar", null, "elena@bgsu.edu", "Manager")));
		
		
		//--exec insert_reimbursement(staff_id,  amount, description, image, 'type desc');
		System.out.println(ReimbursementService.getReimbursementService().registerReimbursementSecure(
				new Reimbursement(1,  212, "java", null, "coffee")));
	
		System.out.println("done");
		
		//insert_staff("username", "password", , "elena", "vollmar", null || phone, "elena@bgsu.edu", "Manager")
		//Test select all
		System.out.println(StaffService.getStaffService().listAllUsers());
		System.out.println(ReimbursementService.getReimbursementService().listAllUsers());
		//Test login
//		System.out.println(StaffService.getStaffService().login(
//				new Staff("david","vollmar")));
	}
}
