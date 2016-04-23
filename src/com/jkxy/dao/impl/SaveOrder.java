package com.jkxy.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jkxy.dao.ISaveOrderDao;
import com.jkxy.model.Orders;

public class SaveOrder implements ISaveOrderDao {
	private SessionFactory sessionfactory;
	
	
	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}


	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}


	@Override
	public Orders saveOderDao(Orders order) {
		Session ses=sessionfactory.openSession();
		Transaction trans=ses.beginTransaction();
		ses.save(order);
		trans.commit();
		ses.close();
		
		return order;
	}

}






