package com.dyb.kfc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dyb.kfc.dao.MealDAO;
import com.dyb.kfc.dao.OrderDAO;
import com.dyb.kfc.dao.OrderDetailDAO;
import com.dyb.kfc.dao.impl.MealDAOImpl;
import com.dyb.kfc.dao.impl.OrderDAOImpl;
import com.dyb.kfc.dao.impl.OrderDetailDAOImpl;
import com.dyb.kfc.entity.Meal;
import com.dyb.kfc.entity.Order;
import com.dyb.kfc.entity.OrderDetail;
import com.dyb.kfc.entity.User;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/order/*")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderDAO orderDAO = new OrderDAOImpl();
	private OrderDetailDAO orderdetailDAO = new OrderDetailDAOImpl();
	private MealDAO mealDAO = new MealDAOImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pathinfo = request.getPathInfo();
		HttpSession session = request.getSession();
		if ("/selectByUser".equals(pathinfo)) {// 查询某个用户的订单
			// 获取当前用户
			User currUser = (User) session.getAttribute("currUser");
			// 根据用户id查询历史订单
			List<Order> orders = orderDAO.selectOrdersByUser(currUser.getId());
			session.setAttribute("orders", orders);
			// 跳转到历史订单页
			response.sendRedirect(request.getContextPath() + "/orders.jsp");
		}

		if ("/orderdetail".equals(pathinfo)) {
			// 产看订单详情
			int id = Integer.parseInt(request.getParameter("id"));
			List<OrderDetail> orderdetails = orderdetailDAO.findOrderDetailByOid(id);
			List<Meal> meals = new ArrayList<Meal>();
			Order order = (Order) orderDAO.selectOrdersByOrder(id);
			for (OrderDetail orderdetail : orderdetails) {
				Meal meal = mealDAO.findMeal(orderdetail.getMid());
				meals.add(meal);
			}
			// 订单详细信息保存在session
			session.setAttribute("bought", meals);
			session.setAttribute("order", order);
			response.sendRedirect(request.getContextPath() + "/orderdetail.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
