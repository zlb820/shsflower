package com.jkxy.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import com.jkxy.model.Orderitem;
import com.jkxy.model.Orders;
import com.jkxy.model.User;
import com.jkxy.service.ISaveOrderService;
import com.jkxy.tool.Cart;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class orderAction extends ActionSupport {
	private ISaveOrderService saveOrderService;

	public ISaveOrderService getSaveOrderService() {
		return saveOrderService;
	}

	public void setSaveOrderService(ISaveOrderService saveOrderService) {
		this.saveOrderService = saveOrderService;
	}
	public String checkOut() throws Exception{
		Map session=(Map)ActionContext.getContext().getSession();
		User user=(User) session.get("user");
		Cart cart=(Cart) session.get("cart");
		if(user==null){
			return "error";
			
		}
		
		Orders order=new Orders();
		order.setOrderdate(new Timestamp(new Date().getTime()));
		order.setUser(user);
		for(Iterator itor=cart.getCartitems().values().iterator();itor.hasNext();){
			Orderitem orderitems=(Orderitem) itor.next();
			order.getOrderitems().add(orderitems);
			orderitems.setOrders(order);
			
		}
		System.out.println("提交订单");
		
		saveOrderService.saveOrder(order);
		
		
		System.out.println("订单提交完成、、、、、");
		Map request=(Map) ActionContext.getContext().get("request");
		request.put("request", "order");
		session.remove(cart);
		
		
		return "success";
	}
}






