package com.jkxy.service;

import java.util.List;

public interface IFlowerService {
	public List getNewFlower();
	public List getFlowerByCatalogidPaging(int catalogid,int currentPage,int pageSize);
	public int getTotalByCatalog(int catalogid);
}
