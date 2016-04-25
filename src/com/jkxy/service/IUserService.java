package com.jkxy.service;

import java.util.List;

import com.jkxy.model.User;

public interface IUserService {
	public boolean addOrUpdateUser(User user);
	public User checkUser(User user);
	public boolean guashiUser(int id);
	public boolean jieguaUser(int id);
	public List getGuashi();
}
