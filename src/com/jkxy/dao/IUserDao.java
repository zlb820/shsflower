package com.jkxy.dao;

import java.util.List;

import com.jkxy.model.User;

public interface IUserDao {
	public boolean addOrUpdateUser(User user);
	public User checkUser(User user);
	//用户挂失 
	public boolean guashiUser(int id);
	public boolean jieguaUser(int id);
	//查询挂失用户
	public List getGuashi();
	

}
