package com.revature;

import com.revature.model.Staff;
import com.revature.service.StaffService;
import com.revature.model.Reimbursement;
import com.revature.service.ReimbursementService;

/* Welcome to the Java */
public class Main {
	public static void main(String[] args) {
		//A Manager can register an Employee, which sends the Employee an email with their username and temp password (optional)
//		System.out.println(StaffService.getStaffService().registerStaffSecure(
//				//("username", "password", , "elena", "vollmar", null || phone, "elena@bgsu.edu", "Manager")
//				new Staff("username", "password", 4, "elena", "vollmar", "419-494-5566", "elena@bgsu.edu", "Manager")));
//						
//		
//		//An Employee can submit a reimbursement request || an image of his/her receipt as part of the reimbursement request (hard / do last)
//		System.out.println(ReimbursementService.getReimbursementService().registerReimbursementSecure(
//				//(staff_id,  amount, description, image, 'type desc');
//				new Reimbursement(1,  212, "java", null, "coffee")));
		
		//An Employee can update their information
//		System.out.println(StaffService.getStaffService().updateStaffSecure(
//				//('user', 'password', 'first_name', 'last_name', 'phone', 'email')
//				new Staff("usernamed", "pot","Bat", "Man", "419-494-5566", "coffee@google.com")));

		//An Employee can view their information
		System.out.println(StaffService.getStaffService().listAllDetails(
				//('user', 'password', 'first_name', 'last_name', 'phone', 'email')
				new Staff("username")));
		
		//A Manager can view all Employees
		System.out.println(StaffService.getStaffService().listAllUsers());
//		
//		
//		// An Employee can view their pending/resolved requests from all employees
//		System.out.println(ReimbursementService.getReimbursementService().listAllStaffRequests(
//				new Reimbursement(1, "PENDING")));
//		System.out.println(ReimbursementService.getReimbursementService().listAllStaffRequests(
//				new Reimbursement(1, "RESOLVED")));
//		
//		//A Manager can view reimbursement requests from a single Employee
//		System.out.println(ReimbursementService.getReimbursementService().listAllUsersRequests(
//				new Reimbursement(1)));
//
//		//A Manager can view all pending/resolved requests from all employees
//		System.out.println(ReimbursementService.getReimbursementService().listAllUserRequestees(
//				new Reimbursement("PENDING")));
//		System.out.println(ReimbursementService.getReimbursementService().listAllUserRequestees(
//				new Reimbursement("RESOLVED")));
//		
//		//A Manager can view all requests from all employees
//		System.out.println(ReimbursementService.getReimbursementService().listAllUsers());
		
		
		
//		//Test login
//		System.out.println(StaffService.getStaffService().login(
//				new Staff("david","vollmar")));
	}
}
