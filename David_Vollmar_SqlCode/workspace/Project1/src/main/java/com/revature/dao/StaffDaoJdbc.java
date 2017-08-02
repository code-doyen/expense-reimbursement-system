package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Staff;
import com.revature.util.ConnectionUtil;
import com.revature.util.LogUtil;

/* JDBC implementation for DAO contract for staffs data access */
public class StaffDaoJdbc implements StaffDao {
	
	/*Singleton transformation of JDBC implementation object */
	private static StaffDaoJdbc staffDaoJdbc;
	
	private StaffDaoJdbc() {
		
	}
	
	public static StaffDaoJdbc getStaffDaoJdbc() {
		if(staffDaoJdbc == null) {
			staffDaoJdbc = new StaffDaoJdbc();
		}
		
		return staffDaoJdbc;
	}
	
	/* Regular insert statement for staff */
//	@Override
//	public boolean insert(Staff staff) {
//		try(Connection connection = ConnectionUtil.getConnection()) {
//			int statementIndex = 0;
//			String command = "INSERT INTO staff VALUES(NULL,?,?,?,?)";
//
//			PreparedStatement statement = connection.prepareStatement(command);
//
//			//Set attributes to be inserted
//			statement.setString(++statementIndex, staff.getFirstName().toUpperCase());
//			statement.setString(++statementIndex, staff.getLastName().toUpperCase());
//			statement.setString(++statementIndex, staff.getUsername().toLowerCase());
//			statement.setString(++statementIndex, staff.getPassword());
//			
//
//			if(statement.executeUpdate() > 0) {
//				return true;
//			}
//		} catch (SQLException e) {
//			LogUtil.logger.warn("Exception creating a new staff", e);
//		}
//		return false;
//	}

	/* Insert a staff using the stored procedure we created */
	@Override
	public boolean insertProcedure(Staff staff) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			
			//Pay attention to this syntax
			//insert_staff('user', 'pass', 5, 'david', 'vollmar', null || phone, 'vollmad@bgsu.edu', 'Pro')
			String command = "{call insert_staff(?,?,?,?,?,?,?,?)}";
			
			//Notice the CallableStatement
			CallableStatement statement = connection.prepareCall(command);
			
			//Set attributes to be inserted
			statement.setString(++statementIndex, staff.getUsername().toLowerCase());
			statement.setString(++statementIndex, staff.getPassword());
			statement.setInt(++statementIndex, staff.getRank());
			statement.setString(++statementIndex, staff.getFirstName());
			statement.setString(++statementIndex, staff.getFirstName().toUpperCase());
			statement.setString(++statementIndex, staff.getPhone());
			statement.setString(++statementIndex, staff.getEmail());
			statement.setString(++statementIndex, staff.getPosition().toUpperCase());
			
			if(statement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception creating a new staff with stored procedure", e);
		}
		return false;
	}

	/* Select staff based on his username */
	@Override
	public Staff select(Staff staff) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			String command = "select staff_id, staff_username, staff_password, staff_rank, staff_first_name, staff_last_name, staff_phone, staff_email, rank_description as staff_position from staff left join staff_rank on staff_rank = rank_id where staff_username = ?";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setString(++statementIndex, staff.getUsername());
			ResultSet result = statement.executeQuery();

			while(result.next()) {
				
				return new Staff(
						result.getInt("staff_id"),
						result.getString("staff_username"),
						result.getString("staff_password"),
						result.getInt("staff_rank"),
						result.getString("staff_first_name"),
						result.getString("staff_last_name"),
						result.getString("staff_phone"),
						result.getString("staff_email"),
						result.getString("staff_position")
						);
			}
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception selecting a staff", e);
		}
		return new Staff();
	}

	/* Select all staffs */
	public List<Staff> selectAll() {
		try(Connection connection = ConnectionUtil.getConnection()) {
			
			String command = "select staff_id, staff_username, staff_password, staff_rank, staff_first_name, staff_last_name, staff_phone, staff_email, rank_description as staff_position from staff left join staff_rank on staff_rank = rank_id";
			PreparedStatement statement = connection.prepareStatement(command);
			ResultSet result = statement.executeQuery();
			List<Staff> staffList = new ArrayList<>();
			while(result.next()) {
				staffList.add(new Staff(
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

			return staffList;
		} catch (SQLException e) {
			System.out.println("select in");
			LogUtil.logger.warn("Exception selecting all staffs", e);
		} 
		return new ArrayList<>();
	}

	/* Get a staff hash consuming the user defined function we created */
	@Override
	public String getStaffHash(Staff staff) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			String command = "SELECT GET_staff_HASH(?,?) AS HASH FROM DUAL";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setString(++statementIndex, staff.getUsername());
			statement.setString(++statementIndex, staff.getPassword());
			ResultSet result = statement.executeQuery();

			if(result.next()) {
				return result.getString("HASH");
			}
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception getting staff hash", e);
		} 
		return new String();
	}
	
	
}
