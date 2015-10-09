package com.axr.dao;

import com.axr.model.UserLogin;

public interface UserLoginDAO {
	
	public UserLogin getUserLoginByCredentials(String username, String password);
	
	public UserLogin getUserLoginByUserId(int userId);
	
}
