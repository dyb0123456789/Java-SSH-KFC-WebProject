package com.dyb.kfc.dao;

import com.dyb.kfc.entity.User;

/**
 *
 * Title: UserDAO
 *
 * Description: 数据访问层：用户
 *
 */
public interface UserDAO {
	// 登录
	User login(String username, String password);
}
