package com.revature.dao;

import java.util.List;

import com.revature.model.Staff;

/* Contract interface that uses DAO design pattern rules that can be implemented
 * by many types of technologies like JDBC, Hibernate, MongoDB, etc.
 */
public interface StaffDao {
	public boolean insertProcedure(Staff staff);
	public boolean updateProcedure(Staff staff);
	public Staff select(Staff staff);
	public List<Staff> selectAll();
	public String getStaffHash(Staff staff);
	public List<Staff> selectDetails(Staff staff);
	
}
