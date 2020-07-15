package com.dyb.kfc.dao;

import java.util.List;

import com.dyb.kfc.entity.OrderDetail;

public interface OrderDetailDAO {
	int insertOrderDetail(OrderDetail orderDetail);

	List<OrderDetail> findOrderDetailByOid(int oid);
}
