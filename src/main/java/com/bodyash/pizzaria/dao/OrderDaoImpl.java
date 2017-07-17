package com.bodyash.pizzaria.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.bodyash.pizzaria.bean.Order;
import com.bodyash.pizzaria.bean.State;

@Repository("orderDao")
@Transactional
public class OrderDaoImpl extends AbstractDao<Integer, Order> implements OrderDao {

	@Override
	public Order findById(int id) {
		return getByKey(id);
	}

	@Override
	public void deleteById(int id) {
		Order o = getByKey(id);
		delete(o);
	}

	@Override
	public void save(Order order) {
		persist(order);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Order> findAllOrders() {
        List<Order> orders = getSession().createCriteria(Order.class).list();
        return orders;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Order> findAllNewOrders() {
	    	Criteria crit = createEntityCriteria();
	        crit.add(Restrictions.eq("state", State.ORDERED));
	        return (List<Order>) crit.list();
	}

	@Override
	public void updateOrder(Order order) {
		update(order);
	}

}
