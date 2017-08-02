package com.revature.service;

import java.util.List;

import com.revature.dao.StaffDaoJdbc;
import com.revature.model.Staff;

/* Class that executes business logic related to staff */
public class StaffService {
	/*Singleton transformation of Staff Service object */
	private static StaffService staffService;
	
	private StaffService() {
		
	}
	
	public static StaffService getStaffService() {
		if(staffService == null) {
			staffService = new StaffService();
		}
		
		return staffService;
	}
	
	/* Calls the insert method of the DAO */
	//public boolean registerStaff(Staff staff) {
	//	return StaffDaoJdbc.getStaffDaoJdbc().insert(staff);
	//}
	
	/* Calls the insert method that uses stored procedure in DAO */
	public boolean registerStaffSecure(Staff staff) {
		return StaffDaoJdbc.getStaffDaoJdbc().insertProcedure(staff);
	}
	
	/* Calls selectAll method of the DAO */
	public List<Staff> listAllUsers() {
		return StaffDaoJdbc.getStaffDaoJdbc().selectAll();
	}
	
	/* Calls select method of the DAO by username and performs login logic */
	public Staff login(Staff staff) {
		//Get user information without validating
		Staff loggedStaff = StaffDaoJdbc.getStaffDaoJdbc().select(staff);
		
		/*
		 * loggedStaff.getPassword() is the hash we have stored.
		 * We compare that against the hash of the user input.
		 * If credentials are correct we return the full Staff information.
		 * Else, we return a blank object.
		 */
		if(loggedStaff.getPassword().equals(StaffDaoJdbc.getStaffDaoJdbc().getStaffHash(staff))) {
			return loggedStaff;
		}
		
		return new Staff();
	}
}
