package com.dyb.kfc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dyb.kfc.dao.OrderDAO;
import com.dyb.kfc.entity.Order;
import com.dyb.kfc.util.JDBCUtil;

public class OrderDAOImpl implements OrderDAO {

	@Override
	public int insertOrder(Order order) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		int id = 0;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "insert into orders(oid,uid,price,otime) values(?,?,?,?)";
			// 返回主键
			psmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			psmt.setString(1, order.getOid());
			psmt.setInt(2, order.getUid());
			psmt.setDouble(3, order.getPrice());
			psmt.setString(4, order.getOtime());
			psmt.executeUpdate();
			// 获取主键
			rs = psmt.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getInt(1);// 新增记录的id值
			}
			return id;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, psmt, conn);
		}
		return 0;
	}

	@Override
	public List<Order> selectOrdersByUser(int uid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<Order> orders = new ArrayList<Order>();
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from orders where uid =?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, uid);
			rs = psmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String oid = rs.getString(2);
				int uid1 = rs.getInt(3);
				double price = rs.getDouble(4);
				String otime = rs.getString(5);
				Order order = new Order(id, oid, uid1, price, otime);
				orders.add(order);
			}
			return orders;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, psmt, conn);
		}
		return null;
	}

	@Override
	public Order selectOrdersByOrder(int id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from orders where id=?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			rs.next();
			int id1 = rs.getInt(1);
			String oid1 = rs.getString(2);
			int uid = rs.getInt(3);
			double price = rs.getDouble(4);
			String otime = rs.getString(5);
			Order order = new Order(id1, oid1, uid, price, otime);
			return order;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, psmt, conn);
		}
		return null;
	}

}
