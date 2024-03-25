package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.exception.UserNotFoundException;
import com.hexaware.model.Role;
import com.hexaware.model.User;
import com.hexaware.util.DBUtil;

public class UserDao {

	public boolean createUser(User user) throws SQLException {

		boolean isCreated = false;
		Connection conn = DBUtil.getDBConn();

		String query = "INSERT INTO User(userId, username, password,  Role)" + "VALUES (?, ?, ?, ?)";

		PreparedStatement ps = conn.prepareStatement(query);

		ps.setInt(1, user.getUserId());
		ps.setString(2, user.getUsername());
		ps.setString(3, user.getPassword());
		ps.setString(4, user.getRole().name());

		int rowsAffected = ps.executeUpdate();

		DBUtil.dbClose();
		if (rowsAffected == 1) {
			isCreated = true;
		} else {
			isCreated = false;
		}
		return isCreated;
	}

	public User getAdminByUsername(String username) throws UserNotFoundException, SQLException {

		Connection conn = DBUtil.getDBConn();

		String query = "select * from User where username = ? and role = ?";

		PreparedStatement ps = conn.prepareStatement(query);

		ps.setString(1, username);
		ps.setString(2, "admin");
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {

			int userId = rs.getInt("userId");
			String userName = rs.getString("username");
			String password = rs.getString("password");
			String role = rs.getString("role");

			User user = new User();

			user.setUserId(userId);
			user.setUsername(userName);
			user.setPassword(password);
			user.setRole(Role.valueOf(role.toUpperCase()));

			DBUtil.dbClose();
			return user;
		}

		DBUtil.dbClose();
		throw new UserNotFoundException("Admin with username" + " " + username + " " + "not found");

	}
	
	public User getUserByUsername(String username) throws UserNotFoundException, SQLException {

		Connection conn = DBUtil.getDBConn();

		String query = "select * from User where username = ? and role = ?";

		PreparedStatement ps = conn.prepareStatement(query);

		ps.setString(1, username);
		ps.setString(2, "user");
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {

			int userId = rs.getInt("userId");
			String userName = rs.getString("username");
			String password = rs.getString("password");
			String role = rs.getString("role");

			User user = new User();

			user.setUserId(userId);
			user.setUsername(userName);
			user.setPassword(password);
			user.setRole(Role.valueOf(role.toUpperCase()));

			DBUtil.dbClose();
			return user;
		}

		DBUtil.dbClose();
		throw new UserNotFoundException("User with username" + " " + username + " " + "not found");

	}


}
