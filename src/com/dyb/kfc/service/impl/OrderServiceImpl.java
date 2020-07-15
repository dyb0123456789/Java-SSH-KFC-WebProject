package com.dyb.kfc.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.dyb.kfc.dao.OrderDAO;
import com.dyb.kfc.dao.OrderDetailDAO;
import com.dyb.kfc.dao.impl.OrderDAOImpl;
import com.dyb.kfc.dao.impl.OrderDetailDAOImpl;
import com.dyb.kfc.entity.Meal;
import com.dyb.kfc.entity.Order;
import com.dyb.kfc.entity.OrderDetail;
import com.dyb.kfc.service.OrderService;

/**
 *
 * Title: OrderServiceImpl
 *
 * Description: 业务层：完成复杂的业务逻辑 事务管理
 * 
 *
 *
 */
public class OrderServiceImpl implements OrderService {
	private OrderDAO orderDAO = new OrderDAOImpl();
	private OrderDetailDAO detailDAO = new OrderDetailDAOImpl();

	@Override
	public void addOrder(Order order, List<Meal> meals) {
		// 生成订单
		int oid = orderDAO.insertOrder(order); // 返回主键
		// 生成对应的订单详情
		List<OrderDetail> details = new ArrayList<OrderDetail>();
		for (Meal meal : meals) {
			OrderDetail detail = new OrderDetail(0, oid, meal.getId());
			details.add(detail);
		}
		for (OrderDetail detail : details) {
			detailDAO.insertOrderDetail(detail);
		}

	}

}
