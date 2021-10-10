package com.flyaway.dao;

import java.util.List;

import com.flyaway.bean.UserData;

public interface UserDataDao {
	
	public boolean saveUser(UserData user);
	public UserData getUser(String email);
	public List<UserData> getAllUser();
	public void updateUser(UserData user);

}
