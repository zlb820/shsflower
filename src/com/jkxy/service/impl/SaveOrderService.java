package com.jkxy.service.impl;

import com.jkxy.dao.ISaveOrderDao;
import com.jkxy.model.Orders;
import com.jkxy.service.ISaveOrderService;


public class SaveOrderService implements ISaveOrderService {
	private ISaveOrderDao saveOrderDao;
	
	public ISaveOrderDao getSaveOrderDao() {
		return saveOrderDao;
	}

	public void setSaveOrderDao(ISaveOrderDao saveOrderDao) {
		this.saveOrderDao = saveOrderDao;
	}

	@Override
	public Orders saveOrder(Orders order) {
		
		return saveOrderDao.saveOderDao(order);
	}
	
}
