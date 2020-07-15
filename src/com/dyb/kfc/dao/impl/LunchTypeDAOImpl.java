package com.dyb.kfc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dyb.kfc.dao.LunchTypeDAO;
import com.dyb.kfc.entity.LunchType;
import com.dyb.kfc.util.JDBCUtil;

public class LunchTypeDAOImpl implements LunchTypeDAO {

	@Override
	public List<LunchType> findAll() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<LunchType> list = new ArrayList<LunchType>();
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from lunchtype";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String typeName = rs.getString(2);
				LunchType lType = new LunchType(id, typeName);
				list.add(lType);
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
