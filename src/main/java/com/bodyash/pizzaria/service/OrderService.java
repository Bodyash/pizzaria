package com.bodyash.pizzaria.service;

import java.util.List;

import com.bodyash.pizzaria.bean.Cart;
import com.bodyash.pizzaria.bean.Order;

public interface OrderService {
	
	public Order findById(int id);
	public void deleteById(int id);
	public void save(Order order);
	public List<Order> findAllOrders();
	public List<Order> findAllNewOrders();
	public void updateOrder(Order order);

}
