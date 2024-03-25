package com.hexaware.controller;

public interface IAuthenticateService {

	public boolean isUserExists(String username, String password);
	
	public boolean isAdminExists(String username, String password);
}
