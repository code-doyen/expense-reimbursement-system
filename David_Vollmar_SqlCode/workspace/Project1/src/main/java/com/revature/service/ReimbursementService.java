package com.revature.service;

import java.util.List;

import com.revature.dao.ReimbursementDaoJdbc;
import com.revature.model.Reimbursement;

/* Class that executes business logic related to reimbursement */
public class ReimbursementService {
	/*Singleton transformation of Reimbursement Service object */
	private static ReimbursementService reimbursementService;
	
	private ReimbursementService() {
		
	}
	
	public static ReimbursementService getReimbursementService() {
		if(reimbursementService == null) {
			reimbursementService = new ReimbursementService();
		}
		
		return reimbursementService;
	}
	
	/* Calls the insert method that uses stored procedure in DAO */
	public boolean registerReimbursementSecure(Reimbursement reimbursement) {
		return ReimbursementDaoJdbc.getReimbursementDaoJdbc().insertProcedure(reimbursement);
	}
	
	/* Calls selectAll method of the DAO */
	public List<Reimbursement> listAllUsers() {
		return ReimbursementDaoJdbc.getReimbursementDaoJdbc().selectAll();
	}
	
	public List<Reimbursement> listAllStaffRequests(Reimbursement reimbursement) {
		return ReimbursementDaoJdbc.getReimbursementDaoJdbc().selectAll(reimbursement);
	}
	
	public List<Reimbursement> listAllUsersRequests(Reimbursement reimbursement) {
		return ReimbursementDaoJdbc.getReimbursementDaoJdbc().selectAllUsersRequests(reimbursement);
	}
	
	public List<Reimbursement> listAllUserRequestees(Reimbursement reimbursement) {
		return ReimbursementDaoJdbc.getReimbursementDaoJdbc().selectAllUserRequestees(reimbursement);
	}
}
