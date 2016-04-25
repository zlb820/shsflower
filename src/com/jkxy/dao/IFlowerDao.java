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
	//添加，修改 花品
	public boolean addOrUpdateFlower(Flower flower);
	//获取 所有 花品list
	public List getAllFlower();
	//删除花品
	public boolean deleteFlower(int flowerid);
	
	
}
