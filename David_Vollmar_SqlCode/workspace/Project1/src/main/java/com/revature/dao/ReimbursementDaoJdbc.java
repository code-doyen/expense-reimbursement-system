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
	
	/* Regular insert statement for reimbursement */
	@Override
	public boolean insert(Reimbursement reimbursement) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			String command = "INSERT INTO reimbursement VALUES(NULL,?,?,?,?)";

			PreparedStatement statement = connection.prepareStatement(command);

			//Set attributes to be inserted
			statement.setString(++statementIndex, reimbursement.getFirstName().toUpperCase());
			statement.setString(++statementIndex, reimbursement.getLastName().toUpperCase());
			statement.setString(++statementIndex, reimbursement.getUsername().toLowerCase());
			statement.setString(++statementIndex, reimbursement.getPassword());
			

			if(statement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception creating a new reimbursement", e);
		}
		return false;
	}

	/* Insert a reimbursement using the stored procedure we created */
	@Override
	public boolean insertProcedure(Reimbursement reimbursement) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			
			//Pay attention to this syntax
			//insert_reimbursement('user', 'pass', 5, 'david', 'vollmar', null || phone, 'vollmad@bgsu.edu', 'Pro')
			String command = "{call insert_reimbursement(?,?,?,?,?,?,?,?)}";
			
			//Notice the CallableStatement
			CallableStatement statement = connection.prepareCall(command);
			
			//Set attributes to be inserted
			statement.setString(++statementIndex, reimbursement.getUsername().toLowerCase());
			statement.setString(++statementIndex, reimbursement.getPassword());
			statement.setInt(++statementIndex, reimbursement.getRank());
			statement.setString(++statementIndex, reimbursement.getFirstName());
			statement.setString(++statementIndex, reimbursement.getFirstName().toUpperCase());
			statement.setString(++statementIndex, reimbursement.getPhone());
			statement.setString(++statementIndex, reimbursement.getEmail());
			statement.setString(++statementIndex, reimbursement.getPosition().toUpperCase());
			
			if(statement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception creating a new reimbursement with stored procedure", e);
		}
		return false;
	}

	/* Select reimbursement based on his username */
	@Override
	public Reimbursement select(Reimbursement reimbursement) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			String command = "select reimbursement_id, reimbursement_username, reimbursement_password, reimbursement_rank, reimbursement_first_name, reimbursement_last_name, reimbursement_phone, reimbursement_email, rank_description as staff_position from staff left join staff_rank on staff_rank = rank_id where staff_username = ?";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setString(++statementIndex, reimbursement.getUsername());
			ResultSet result = statement.executeQuery();

			while(result.next()) {
				
				return new Reimbursement(
						result.getInt("reimbursement_id"),
						result.getString("reimbursement_username"),
						result.getString("reimbursement_password"),
						result.getInt("reimbursement_rank"),
						result.getString("reimbursement_first_name"),
						result.getString("reimbursement_last_name"),
						result.getString("reimbursement_phone"),
						result.getString("reimbursement_email"),
						result.getString("reimbursement_position")
						);
			}
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception selecting a reimbursement", e);
		}
		return new Reimbursement();
	}

	/* Select all reimbursements */
	public List<Reimbursement> selectAll() {
		try(Connection connection = ConnectionUtil.getConnection()) {
			
			String command = "select staff_id, staff_username, staff_password, staff_rank, staff_first_name, staff_last_name, staff_phone, staff_email, rank_description as staff_position from staff left join staff_rank on staff_rank = rank_id";
			PreparedStatement statement = connection.prepareStatement(command);
			ResultSet result = statement.executeQuery();
			List<Reimbursement> reimbursementList = new ArrayList<>();
			while(result.next()) {
				reimbursementList.add(new Reimbursement(
						result.getInt("staff_id"),
						result.getString("staff_username"),
						result.getString("staff_password"),
						result.getInt("staff_rank"),
						result.getString("staff_first_name"),
						result.getString("staff_last_name"),
						result.getString("staff_phone"),
						result.getString("staff_email"),
						result.getString("staff_position")
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
