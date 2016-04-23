package com.jkxy.dao;

import java.util.List;

import com.jkxy.model.Flower;

public interface IFlowerDao {
	//获取 新入库 flower 列表
	public List getNewFlower();
	//获取 flower 列表
	public List getFlowerByCatalogidPaging(int catalogid,int currentPage,int pageSize);
	//获取 菜单 列表
	public int getTotalByCatalog(int catalogid);
	//根据id 查询 flower
	public Flower getFlowerById(int id);
	
}
