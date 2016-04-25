package com.jkxy.service.impl;

import java.util.List;

import com.jkxy.dao.IUserDao;
import com.jkxy.model.User;
import com.jkxy.service.IUserService;

public class UserService implements IUserService {
	private IUserDao userDao;
	
	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean addOrUpdateUser(User user) {
		return userDao.addOrUpdateUser(user);
	}

	@Override
	public User checkUser(User user) {
		return userDao.checkUser(user);
	}

	@Override
	public boolean guashiUser(int id) {
		
		return userDao.guashiUser(id);
	}

	@Override
	public boolean jieguaUser(int id) {
		return userDao.jieguaUser(id);
	}

	@Override
	public List getGuashi() {
		return userDao.getGuashi();
	}

}
