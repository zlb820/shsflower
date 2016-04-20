package com.jkxy.dao;

import com.jkxy.model.User;

public interface IUserDao {
	public boolean addOrUpdateUser(User user);
	public User checkUser(User user);
}
