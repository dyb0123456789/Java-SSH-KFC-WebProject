package com.dyb.kfc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dyb.kfc.dao.OrderDetailDAO;
import com.dyb.kfc.entity.OrderDetail;
import com.dyb.kfc.util.JDBCUtil;

public class OrderDetailDAOImpl implements OrderDetailDAO {

	@Override
	public int insertOrderDetail(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		// 插入订单详细内容
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			conn = JDBCUtil.getConnection();
			String sql = "insert into orderdetail(oid,mid) values(?,?)";
			// 返回主键
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, orderDetail.getOid());
			psmt.setInt(2, orderDetail.getMid());
			return psmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, psmt, conn);
		}
		return 0;
	}

	@Override
	public List<OrderDetail> findOrderDetailByOid(int oid) {
		// TODO Auto-generated method stub
		// 获取订单的详细内容
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<OrderDetail> orderdetails = new ArrayList<OrderDetail>();
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select mid from orderdetail where oid=?";
			// 返回主键
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, oid);
			rs = psmt.executeQuery();
			while (rs.next()) {
				int mid = rs.getInt(1);
				OrderDetail orderdetail = new OrderDetail(0, oid, mid);
				orderdetails.add(orderdetail);
			}
			return orderdetails;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, psmt, conn);
		}
		return null;
	}

}
