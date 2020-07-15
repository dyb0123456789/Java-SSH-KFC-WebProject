package com.dyb.kfc.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * Title: JDBCUtil
 *
 * Description: 读取配置文件，获取连接对象 ，关闭资源
 *
 *
 */
public class JDBCUtil {
	private static Properties properties;// 属性集对象
	// 静态块加载配置文件
	static {
		try {
			properties = new Properties();// 实例化属性
			// 读取配置文件
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
			properties.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 获取连接对象
	public static Connection getConnection() throws Exception {

		Class.forName(properties.getProperty("jdbc.driver"));
		return DriverManager.getConnection(properties.getProperty("jdbc.url"), properties.getProperty("jdbc.username"),
				properties.getProperty("jdbc.password"));

	}

	// 关闭资源
	// 解决异常的快捷键是ctrl+1
	public static void close(ResultSet rs, PreparedStatement psmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
