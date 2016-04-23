package com.jkxy.tool;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.jkxy.model.Flower;
import com.jkxy.model.Orderitem;

public class Cart {
	private Map cartitems;

	

	public Map getCartitems() {
		return cartitems;
	}

	public void setCartitems(Map cartitems) {
		this.cartitems = cartitems;
	}

	public Cart() {
		// TODO Auto-generated constructor stub
		if (cartitems == null)
			cartitems = new HashMap<Integer, Orderitem>();
	}

	public void addFlower(int flowerId, Orderitem orderitem) {
		if (cartitems.containsKey(flowerId)) {
			Orderitem _orderitem = (Orderitem) cartitems.get(flowerId);
			orderitem.setQuantity(_orderitem.getQuantity()
					+ orderitem.getQuantity());
			cartitems.put(flowerId, orderitem);
		} else
			cartitems.put(flowerId, orderitem);
	}

	public void updateCart(int flowerId, int quantity) {
		Orderitem orderitem = (Orderitem) cartitems.get(flowerId);
		orderitem.setQuantity(quantity);
		cartitems.put(flowerId, orderitem);
	}

	public int getTotalPrice() {
		int totalPrice = 0;
		for (Iterator it = cartitems.values().iterator(); it.hasNext();) {
			Orderitem orderitem = (Orderitem) it.next();
			Flower flower = orderitem.getFlower();
			int quantity = orderitem.getQuantity();
			totalPrice += flower.getPrice() * quantity;
		}
		return totalPrice;
	}
}
