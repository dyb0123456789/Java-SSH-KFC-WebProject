package com.dyb.kfc.dao;

import java.util.List;

import com.dyb.kfc.entity.Order;

public interface OrderDAO {
	/**
	 * 
	 * @param order
	 * @return 新增订单的id
	 */
	int insertOrder(Order order);

	List<Order> selectOrdersByUser(int uid);

	Order selectOrdersByOrder(int id);
}
