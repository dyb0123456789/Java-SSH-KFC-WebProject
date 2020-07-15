package com.dyb.kfc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dyb.kfc.dao.UserDAO;
import com.dyb.kfc.entity.User;
import com.dyb.kfc.util.JDBCUtil;

/**
 *
 * Title: UserDAOImpl
 *
 * Description:
 *
 *
 *
 */
public class UserDAOImpl implements UserDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gem.book.dao.UserDAO#login(java.lang.String, java.lang.String)
	 */
	@Override
	public User login(String username, String password) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		User currUser = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from user where username=? and password=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, username);
			psmt.setString(2, password);
			rs = psmt.executeQuery();
			if (rs.next()) {
				int id = rs.getInt(1);
				String user = rs.getString(2);
				String pwd = rs.getString(3);
				currUser = new User(id, user, pwd);
			}
			return currUser;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, psmt, conn);
		}
		return null;
	}

}
