package com.jkxy.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jkxy.dao.IUserDao;
import com.jkxy.model.Guashi;
import com.jkxy.model.User;

public class UserDao implements IUserDao {
	private SessionFactory sessionfactory;

	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	@Override
	public boolean addOrUpdateUser(User user) {
		Session ses = sessionfactory.openSession();
		Transaction trans = ses.beginTransaction();
		ses.saveOrUpdate(user);
		trans.commit();
		ses.close();

		return true;

	}

	@Override
	public User checkUser(User user) {
		/*
		 * Session session = sessionfactory.openSession(); Transaction ts =
		 * session.beginTransaction(); Query query =
		 * session.createQuery("from User where username='" + user.getUsername()
		 * + "' and password='" + user.getPassword() + "' and role='" +
		 * user.getRole() + "'"); User user1 = new User(); List<User> list =
		 * query.list(); System.out.println("用户名：" + list.get(0).getUsername());
		 * ts.commit(); session.close(); if (list.size() == 0) { return null; }
		 * user1 = (User) list.get(0); return user1;
		 */
		// 测试 登陆

		if ("zlb820".equals(user.getUsername())
				&& "zlb820".equals(user.getPassword())) {
			User user1 = new User();
			user1.setUsername("zlb820");
			user1.setPassword("zlb820");
			user1.setRole("customer");
			user1.setUserid(6);
			return user1;
		} else {

			return null;
		}

		/*
		 * Session session = sessionfactory.openSession(); String hql =
		 * "FROM User WHERE username = ? AND password = ? AND role = ?"; Query
		 * query = session.createQuery(hql); query.setString(0,
		 * user.getUsername()); query.setString(1,user.getPassword());
		 * query.setString(2,user.getRole()); List<User> list=query.list();
		 * for(User users:list){
		 * System.out.println("Yonghuming:"+users.getUsername()); } return null;
		 */

	}

	@Override
	public boolean guashiUser(int id) {
		Session ses=sessionfactory.openSession();
		Transaction trans=ses.beginTransaction();
		Query query=ses.createQuery("from User where userid="+id);
		User user1=(User) query.list().get(0);
		Guashi guashi1=new Guashi();
		guashi1.setUser(user1);
		user1.setGuashi(guashi1);
		ses.saveOrUpdate(guashi1);
		trans.commit();
		ses.close();
		
		return true;
	}

	@Override
	public boolean jieguaUser(int id) {
		Session ses=sessionfactory.openSession();
		Transaction trans=ses.beginTransaction();
		Query query=ses.createQuery("from User where userid="+id);
		User user1=(User) query.list().get(0);
		ses.delete(user1.getGuashi());
		trans.commit();
		ses.close();
		return true;
	}

	@Override
	public List getGuashi() {
		Session ses=sessionfactory.openSession();
		Transaction trans=ses.beginTransaction();
		Query query=ses.createQuery("from Guashi");
		List list=query.list();
		trans.commit();
		ses.close();
		return list;
	}

}
