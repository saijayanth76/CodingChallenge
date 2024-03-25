package com.hexaware.controller;

import java.sql.SQLException;

import com.hexaware.dao.UserDao;
import com.hexaware.exception.UserNotFoundException;
import com.hexaware.model.User;

public class AuthenticateService implements IAuthenticateService{

	UserDao userDao = new UserDao();
	@Override
	public boolean isUserExists(String username, String password) {
		try {
			User user = userDao.getUserByUsername(username);
			
			if(user.getPassword().equals(password.trim())) {
				return true;
			}
		} catch (UserNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean isAdminExists(String username, String password) {
		
		try {
			User user = userDao.getAdminByUsername(username);
			
			if(user.getPassword().equals(password.trim())) {
				return true;
			}
		} catch (UserNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}

}
