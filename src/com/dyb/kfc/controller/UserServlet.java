package com.dyb.kfc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dyb.kfc.dao.UserDAO;
import com.dyb.kfc.dao.impl.UserDAOImpl;
import com.dyb.kfc.entity.User;

/**
 * Servlet implementation class UserServlet servelt由tomcat管理
 * servlet的生命周期涉及的方法(init()、service()、destroy())
 */
@WebServlet("/user/*")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO = new UserDAOImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response) 处理http协议 get请求 通常url访问(浏览器地址栏输入、超链接、转发和重定向)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 处理用户请求
		// 1、登录请求
		String pathInfo = request.getPathInfo();// 匹配servlet url中的*
		HttpSession session = request.getSession();
		if ("/login".equals(pathInfo)) {
			// 登录请求
			// 请求处理：
			// 获取输入的用户名和密码(获取请求参数)
			String username = request.getParameter("username");// 与表单中的name属性值一直
			String password = request.getParameter("password");
			User user = userDAO.login(username, password);// 调用数据访问层(dao)查询数据库
			if (user != null) {
				// 登录成功
				// session域中保存当前用户信息
				session.setAttribute("currUser", user);

				// 跳转到餐品servlet
				response.sendRedirect(request.getContextPath() + "/meal/index");

			} else {
				// 登录失败
				// 重新登录，跳转到登录页
				// 使用重定向进行页面跳转
				// http://localhost:8080/KFCWeb/user/login跳转到
				// http://localhost:8080/KFCWeb/login.jsp
				// request.getContextPath() 获取web项目的访问路径
				response.sendRedirect(request.getContextPath() + "/login.jsp?info=1");
			}
		}
		if ("/logout".equals(pathInfo)) {// 退出登录
			session.invalidate();
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response) 处理http的post请求(form表单method="post",默认get请求、ajax中指明post)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
