package com.jkxy.dao;

import java.util.List;

public interface IFlowerDao {
	public List getNewFlower();
	public List getFlowerByCatalogidPaging(int catalogid,int currentPage,int pageSize);
	public int getTotalByCatalog(int catalogid);
}
