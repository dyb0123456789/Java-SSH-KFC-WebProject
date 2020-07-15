package com.dyb.kfc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dyb.kfc.dao.DinnerTypeDAO;
import com.dyb.kfc.entity.DinnerType;
import com.dyb.kfc.util.JDBCUtil;

public class DinnerTypeDAOImpl implements DinnerTypeDAO {

	@Override
	public List<DinnerType> findAll() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<DinnerType> list = new ArrayList<DinnerType>();
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from dinnertype";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String typeName = rs.getString(2);
				DinnerType dType = new DinnerType(id, typeName);
				list.add(dType);
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
