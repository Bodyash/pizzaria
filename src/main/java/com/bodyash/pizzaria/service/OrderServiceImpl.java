package com.bodyash.pizzaria.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bodyash.pizzaria.bean.Cart;
import com.bodyash.pizzaria.bean.Order;
import com.bodyash.pizzaria.dao.OrderDao;

public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDao orderDao;

	@Override
	public Order findById(int id) {
		return orderDao.findById(id);
	}

	@Override
	public void deleteById(int id) {
		orderDao.deleteById(id);
	}

	@Override
	public void save(Order order) {
		orderDao.save(order);
	}

	@Override
	public List<Order> findAllOrders() {
		return orderDao.findAllOrders();
	}

	@Override
	public List<Order> findAllNewOrders() {
		return orderDao.findAllNewOrders();
	}

	@Override
	public void updateOrder(Order order) {
		orderDao.updateOrder(order);
	}

	/*@Override
	public Cart getOrderCart(int orderId) {
		Order order = this.findById(orderId);
		byte[] cartBytes = order.getCart();
		Cart cart = null;
		try (ByteArrayInputStream bais = new ByteArrayInputStream(cartBytes); ObjectInput in = new ObjectInputStream(bais)){
			cart = (Cart) in.readObject();
			return cart;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return cart;
	}
	
	@Override
	public Order setOrderCart(Cart cart, Order order) {
		try (ByteArrayOutputStream bos = new ByteArrayOutputStream(); ObjectOutput out = new ObjectOutputStream(bos)){
			  out.writeObject(cart);
			  out.flush();
			  byte[] cartBytes = bos.toByteArray();
			  order.setCart(cartBytes);
			  return order;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return order;
	}*/

}
