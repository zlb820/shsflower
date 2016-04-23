package com.jkxy.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jkxy.dao.IFlowerDao;
import com.jkxy.model.Flower;
import com.opensymphony.xwork2.ActionContext;

public class FlowerDao implements IFlowerDao {
	public SessionFactory sessionfactory;
	
	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	@Override
	public List getNewFlower() {
		Session ses=sessionfactory.openSession();
		Transaction trans=ses.beginTransaction();
		Query query=ses.createQuery("from Flower order by flowerid desc");
		query.setFirstResult(0);
		query.setMaxResults(4);
		List flowers=query.list();
		trans.commit();
		ses.close();
		System.out.print("我在查询新入库鲜花。。。");
		
		return flowers;
	}

	@Override
	public List getFlowerByCatalogidPaging(int catalogid, int currentPage,
			int pageSize) {
		Session ses=sessionfactory.openSession();
		Transaction trans=ses.beginTransaction();
		Query query =ses.createQuery("from Flower where catalogid="+catalogid);
		int startRow=(currentPage-1)*pageSize;
		query.setFirstResult(startRow);
		query.setMaxResults(pageSize);
		List flowers=query.list();
		trans.commit();
		ses.close();
		System.out.println("我正在分类查询。。。。");
		return flowers;
	}

	@Override
	public int getTotalByCatalog(int catalogid) {
		Session ses=sessionfactory.openSession();
		Transaction trans=ses.beginTransaction();
		Query query =ses.createQuery("from Flower where catalogid="+catalogid);
		List flowers=query.list();
		trans.commit();
		ses.close();
		
		return flowers.size();
	}

	@Override
	public Flower getFlowerById(int  id) {
		
		Session ses=sessionfactory.openSession();
		Transaction trans=ses.beginTransaction();
		Query query=ses.createQuery("from Flower where flowerId="+id);
		List flower=query.list();
		trans.commit();
		ses.close();
		return (Flower) flower.get(0);
	}

}






