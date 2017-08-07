package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Reimbursement;
import com.revature.util.ConnectionUtil;
import com.revature.util.LogUtil;

/* JDBC implementation for DAO contract for staffs data access */
public class ReimbursementDaoJdbc implements ReimbursementDao {
	
	/*Singleton transformation of JDBC implementation object */
	private static ReimbursementDaoJdbc reimbursementDaoJdbc;
	
	private ReimbursementDaoJdbc() {
		
	}
	
	public static ReimbursementDaoJdbc getReimbursementDaoJdbc() {
		if(reimbursementDaoJdbc == null) {
			reimbursementDaoJdbc = new ReimbursementDaoJdbc();
		}
		
		return reimbursementDaoJdbc;
	}
	

	/* Insert a reimbursement using the stored procedure we created */
	@Override
	public boolean insertProcedure(Reimbursement reimbursement) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			
			//Pay attention to this syntax
			//--exec insert_reimbursement(staff_id, amount, description, image, 'type desc');
			String command = "{call insert_reimbursement(?,?,?,?,?)}";
			
			//Notice the CallableStatement
			CallableStatement statement = connection.prepareCall(command);
			
			//Set attributes to be inserted
			statement.setInt(++statementIndex, reimbursement.getStaff_id());
			statement.setInt(++statementIndex, reimbursement.getAmount());
			statement.setString(++statementIndex, reimbursement.getDescription().toUpperCase());
			statement.setBlob(++statementIndex, reimbursement.getImage());//setBlob(parameterIndex, inputStream)
			statement.setString(++statementIndex, reimbursement.getType().toUpperCase());
			
			if(statement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception creating a new reimbursement with stored procedure", e);
		}
		return false;
	}
	
	public boolean updateProcedure(Reimbursement reimbursement) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			
			//Pay attention to this syntax
			String command = "{call update_status(?,?)}";
			
			//Notice the CallableStatement
			CallableStatement statement = connection.prepareCall(command);
			
			//Set attributes to be inserted
			statement.setString(++statementIndex, reimbursement.getStatus().toUpperCase());
			statement.setInt(++statementIndex, reimbursement.getId());
			
			
			if(statement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception updating a reimbursement status with stored procedure", e);
		}
		return false;
	}

	/* Select all reimbursements */
	public List<Reimbursement> selectAll() {
		try(Connection connection = ConnectionUtil.getConnection()) {
			
			String command = "select reimbursement_id, staff_id, (staff_first_name || ' ' || staff_last_name) as reimbursement_staff_requestee, reimbursement_amount, "
					+"reimbursement_description, reimbursement_date_submitted, reimbursement_date_approved, reimbursement_approve_by, "
					+"reimbursement_status_desc as reimbursement_status, "
					+"reimbursement_type_description as reimbursement_type "
					+"from (select reimbursement_id, reimbursement_staff_id, reimbursement_amount, reimbursement_description, reimbursement_date_submitted, "
					+"reimbursement_date_approved, (staff_first_name || ' ' || staff_last_name) as reimbursement_approve_by, reimbursement_status_desc, "
					+"reimbursement_type_description from reimbursement "
					+"left join reimbursement_type on reimbursement_type = reimbursement_type_id "
					+"left join reimbursement_status on reimbursement_pending = reimbursement_status_id "
					+"left join staff on staff_id = reimbursement_approve_by) "
					+"left join staff on staff_id = reimbursement_staff_id";
			PreparedStatement statement = connection.prepareStatement(command);
			
			ResultSet result = statement.executeQuery();
			List<Reimbursement> reimbursementList = new ArrayList<>();
			while(result.next()) {
				reimbursementList.add(new Reimbursement(
						result.getInt("reimbursement_id"),
						result.getInt("staff_id"),
						result.getString("reimbursement_staff_requestee"),
						result.getInt("reimbursement_amount"),
						result.getString("reimbursement_description"),
						result.getString("reimbursement_date_submitted"),
						result.getString("reimbursement_date_approved"),
						result.getString("reimbursement_approve_by"),
						result.getString("reimbursement_status"),
						result.getString("reimbursement_type")
						));
			}

			return reimbursementList;
		} catch (SQLException e) {
			System.out.println("select in");
			LogUtil.logger.warn("Exception selecting all reimbursements", e);
		} 
		return new ArrayList<>();
	}

	@Override
	public List<Reimbursement> selectAll(Reimbursement reimbursement) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			String command = "select reimbursement_id, staff_id, (staff_first_name || ' ' || staff_last_name) as reimbursement_staff_requestee, reimbursement_amount, "
					+"reimbursement_description, reimbursement_date_submitted, reimbursement_date_approved, reimbursement_approve_by, "
					+"reimbursement_status_desc as reimbursement_status, "
					+"reimbursement_type_description as reimbursement_type "
					+"from (select reimbursement_id, reimbursement_staff_id, reimbursement_amount, reimbursement_description, reimbursement_date_submitted, "
					+"reimbursement_date_approved, (staff_first_name || ' ' || staff_last_name) as reimbursement_approve_by, reimbursement_status_desc, "
					+"reimbursement_type_description from reimbursement "
					+"left join reimbursement_type on reimbursement_type = reimbursement_type_id "
					+"left join reimbursement_status on reimbursement_pending = reimbursement_status_id "
					+"left join staff on staff_id = reimbursement_approve_by where reimbursement_status_desc = ?) "
					+"left join staff on staff_id = reimbursement_staff_id where reimbursement_status_desc = ? and reimbursement_staff_id = ?";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setString(++statementIndex, reimbursement.getStatus());
			statement.setString(++statementIndex, reimbursement.getStatus()); 
			statement.setInt(++statementIndex, reimbursement.getStaff_id());
			ResultSet result = statement.executeQuery();
			List<Reimbursement> reimbursementList = new ArrayList<>();
			while(result.next()) {
				reimbursementList.add(new Reimbursement(
						result.getInt("reimbursement_id"),
						result.getInt("staff_id"),
						result.getString("reimbursement_staff_requestee"),
						result.getInt("reimbursement_amount"),
						result.getString("reimbursement_description"),
						result.getString("reimbursement_date_submitted"),
						result.getString("reimbursement_date_approved"),
						result.getString("reimbursement_approve_by"),
						result.getString("reimbursement_status"),
						result.getString("reimbursement_type")
						));
			}

			return reimbursementList;
		} catch (SQLException e) {
			System.out.println("select in");
			LogUtil.logger.warn("Exception selecting all reimbursements", e);
		} 
		return new ArrayList<>();
	}

	@Override
	public List<Reimbursement> selectAllUsersRequests(Reimbursement reimbursement) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			String command = "select reimbursement_id, staff_id, (staff_first_name || ' ' || staff_last_name) as reimbursement_staff_requestee, reimbursement_amount, "
					+ "reimbursement_description, reimbursement_date_submitted, reimbursement_date_approved, reimbursement_approve_by, reimbursement_status_desc as reimbursement_status, "
					+ "reimbursement_type_description as reimbursement_type "
					+ "from (select reimbursement_id, reimbursement_staff_id, reimbursement_amount, reimbursement_description, "
					+ "reimbursement_date_submitted, reimbursement_date_approved, (staff_first_name || ' ' || staff_last_name) as reimbursement_approve_by, reimbursement_status_desc, "
					+ "reimbursement_type_description from reimbursement "
					+ "left join reimbursement_type on reimbursement_type = reimbursement_type_id "
					+ "left join reimbursement_status on reimbursement_pending = reimbursement_status_id "
					+ "left join staff on staff_id = reimbursement_approve_by where reimbursement_staff_id = ?) "
					+ "left join staff on staff_id = reimbursement_staff_id where reimbursement_staff_id = ?";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setInt(++statementIndex, reimbursement.getStaff_id());
			statement.setInt(++statementIndex, reimbursement.getStaff_id());
			ResultSet result = statement.executeQuery();
			System.out.println(result);
			List<Reimbursement> reimbursementList = new ArrayList<>();
			while(result.next()) {
				reimbursementList.add(new Reimbursement(
						result.getInt("reimbursement_id"),
						result.getInt("staff_id"),
						result.getString("reimbursement_staff_requestee"),
						result.getInt("reimbursement_amount"),
						result.getString("reimbursement_description"),
						result.getString("reimbursement_date_submitted"),
						result.getString("reimbursement_date_approved"),
						result.getString("reimbursement_approve_by"),
						result.getString("reimbursement_status"),
						result.getString("reimbursement_type")
						));
			}

			return reimbursementList;
		} catch (SQLException e) {
			System.out.println("select in");
			LogUtil.logger.warn("Exception selecting all reimbursements", e);
		} 
		return new ArrayList<>();
	}
	
	@Override
	public List<Reimbursement> selectAllUserRequestees(Reimbursement reimbursement) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			String command = "select reimbursement_id, staff_id, (staff_first_name || ' ' || staff_last_name) as reimbursement_staff_requestee, reimbursement_amount, "
					+ "reimbursement_description, reimbursement_date_submitted, reimbursement_date_approved, reimbursement_approve_by, reimbursement_status_desc as reimbursement_status, "
					+ "reimbursement_type_description as reimbursement_type "
					+ "from (select reimbursement_id, reimbursement_staff_id, reimbursement_amount, reimbursement_description, reimbursement_date_submitted, "
					+ "reimbursement_date_approved, (staff_first_name || ' ' || staff_last_name) as reimbursement_approve_by, reimbursement_status_desc, "
					+ "reimbursement_type_description from reimbursement "
					+ "left join reimbursement_type on reimbursement_type = reimbursement_type_id "
					+ "left join reimbursement_status on reimbursement_pending = reimbursement_status_id "
					+ "left join staff on staff_id = reimbursement_approve_by where reimbursement_status_desc = ?) "
					+ "left join staff on staff_id = reimbursement_staff_id where reimbursement_status_desc = ?";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setString(++statementIndex, reimbursement.getStatus());
			statement.setString(++statementIndex, reimbursement.getStatus());
			ResultSet result = statement.executeQuery();
			System.out.println(result);
			List<Reimbursement> reimbursementList = new ArrayList<>();
			while(result.next()) {
				reimbursementList.add(new Reimbursement(
						result.getInt("reimbursement_id"),
						result.getInt("staff_id"),
						result.getString("reimbursement_staff_requestee"),
						result.getInt("reimbursement_amount"),
						result.getString("reimbursement_description"),
						result.getString("reimbursement_date_submitted"),
						result.getString("reimbursement_date_approved"),
						result.getString("reimbursement_approve_by"),
						result.getString("reimbursement_status"),
						result.getString("reimbursement_type")
						));
			}

			return reimbursementList;
		} catch (SQLException e) {
			System.out.println("select in");
			LogUtil.logger.warn("Exception selecting all reimbursements", e);
		} 
		return new ArrayList<>();
	}
}

