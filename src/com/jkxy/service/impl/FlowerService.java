package com.jkxy.service.impl;

import java.util.List;

import com.jkxy.dao.IFlowerDao;
import com.jkxy.model.Flower;
import com.jkxy.service.IFlowerService;

public class FlowerService implements IFlowerService {
	public IFlowerDao flowerDao;
	
	public IFlowerDao getFlowerDao() {
		return flowerDao;
	}

	public void setFlowerDao(IFlowerDao flowerDao) {
		this.flowerDao = flowerDao;
	}

	@Override
	public List getNewFlower() {
		return flowerDao.getNewFlower();
	}

	@Override
	public List getFlowerByCatalogidPaging(int catalogid, int currentPage,
			int pageSize) {
		return flowerDao.getFlowerByCatalogidPaging(catalogid, currentPage, pageSize);
	}

	@Override
	public int getTotalByCatalog(int catalogid) {
		return flowerDao.getTotalByCatalog(catalogid);
	}

	@Override
	public Flower getFlowerById(int id) {
		return flowerDao.getFlowerById(id);
	}

	@Override
	public boolean addOrUpdateFlower(Flower flower) {
		return flowerDao.addOrUpdateFlower(flower);
	}

	@Override
	public List getAllFlower() {
		return flowerDao.getAllFlower();
	}

	@Override
	public boolean deleteFlower(int flowerid) {
		
		return flowerDao.deleteFlower(flowerid);
	}

}
