package com.dyb.kfc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dyb.kfc.dao.BreakfastTypeDAO;
import com.dyb.kfc.entity.BreakfastType;
import com.dyb.kfc.util.JDBCUtil;

public class BreakfastTypeDAOImpl implements BreakfastTypeDAO {

	@Override
	public List<BreakfastType> findAll() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<BreakfastType> list = new ArrayList<BreakfastType>();
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from breakfasttype";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String typeName = rs.getString(2);
				BreakfastType bType = new BreakfastType(id, typeName);
				list.add(bType);
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, psmt, conn);
		}

		return null;
	}

}
