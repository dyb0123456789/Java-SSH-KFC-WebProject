package com.dyb.kfc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dyb.kfc.dao.MealDAO;
import com.dyb.kfc.entity.Meal;
import com.dyb.kfc.util.JDBCUtil;

public class MealDAOImpl implements MealDAO {

	@Override
	public List<Meal> findMealByType(int typeId) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<Meal> meals = new ArrayList<Meal>();
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select id,mname,price,remark,mimg from meal where typeid=?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, typeId);
			rs = psmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String mname = rs.getString(2);
				double price = rs.getDouble(3);
				String remark = rs.getString(4);
				String mimg = rs.getString(5);
				Meal meal = new Meal(id, mname, price, remark, mimg);
				meals.add(meal);
			}
			return meals;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, psmt, conn);
		}

		return null;
	}

	@Override
	public List<Meal> findMealByKeyword(String str) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<Meal> meals = new ArrayList<Meal>();
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select id,mname,price,remark,mimg from meal where mname like '%" + str + "%'";
			psmt = conn.prepareStatement(sql);
//			psmt.setString(1, str);
			rs = psmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String mname = rs.getString(2);
				double price = rs.getDouble(3);
				String remark = rs.getString(4);
				String mimg = rs.getString(5);
				Meal meal = new Meal(id, mname, price, remark, mimg);
				meals.add(meal);
			}
			return meals;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, psmt, conn);
		}

		return null;
	}

	@Override
	public Meal findMeal(int mid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		Meal meal = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select id,mname,price,remark,mimg from meal where id=?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, mid);
			rs = psmt.executeQuery();
			rs.next();
			int id = rs.getInt(1);
			String mname = rs.getString(2);
			double price = rs.getDouble(3);
			String remark = rs.getString(4);
			String mimg = rs.getString(5);
			meal = new Meal(id, mname, price, remark, mimg);
			return meal;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, psmt, conn);
		}

		return null;
	}

}
