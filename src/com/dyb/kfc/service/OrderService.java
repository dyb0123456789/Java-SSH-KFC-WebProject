package com.dyb.kfc.service;

import java.util.List;

import com.dyb.kfc.entity.Meal;
import com.dyb.kfc.entity.Order;

public interface OrderService {
	// 下单
	void addOrder(Order order, List<Meal> meals);
}
