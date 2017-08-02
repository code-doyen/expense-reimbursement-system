package com.revature.dao;

import java.util.List;
import com.revature.model.Reimbursement;


/* Contract interface that uses DAO design pattern rules that can be implemented
* by many types of technologies like JDBC, Hibernate, MongoDB, etc.
*/

public interface ReimbursementDao {
	public boolean insert(Reimbursement reimbursement);
	public boolean insertProcedure(Reimbursement reimbursement);
	public Reimbursement select (Reimbursement reimbursement);
	public List<Reimbursement> selectAll();
}
