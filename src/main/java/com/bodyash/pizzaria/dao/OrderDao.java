package com.bodyash.pizzaria.dao;

import java.util.List;

import com.bodyash.pizzaria.bean.Order;

public interface OrderDao {
	
	public Order findById(int id);
	public void deleteById(int id);
	public void save(Order order);
	public List<Order> findAllOrders();
	public List<Order> findAllNewOrders();
	public void updateOrder(Order order);

}
