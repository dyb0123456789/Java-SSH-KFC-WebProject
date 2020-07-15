package com.dyb.kfc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dyb.kfc.dao.BreakfastTypeDAO;
import com.dyb.kfc.dao.DinnerTypeDAO;
import com.dyb.kfc.dao.LunchTypeDAO;
import com.dyb.kfc.dao.MealDAO;
import com.dyb.kfc.dao.impl.BreakfastTypeDAOImpl;
import com.dyb.kfc.dao.impl.DinnerTypeDAOImpl;
import com.dyb.kfc.dao.impl.LunchTypeDAOImpl;
import com.dyb.kfc.dao.impl.MealDAOImpl;
import com.dyb.kfc.entity.BreakfastType;
import com.dyb.kfc.entity.DinnerType;
import com.dyb.kfc.entity.LunchType;
import com.dyb.kfc.entity.Meal;
import com.dyb.kfc.entity.Order;
import com.dyb.kfc.entity.User;
import com.dyb.kfc.service.OrderService;
import com.dyb.kfc.service.impl.OrderServiceImpl;
import com.dyb.kfc.util.DateUtil;

/**
 * Servlet implementation class MealServlet
 */
@WebServlet("/meal/*")
public class MealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BreakfastTypeDAO breakfastTypeDAO = new BreakfastTypeDAOImpl();
	private LunchTypeDAO lunchTypeDAO = new LunchTypeDAOImpl();
	private DinnerTypeDAO dinnerTypeDAO = new DinnerTypeDAOImpl();
	private MealDAO mealDAO = new MealDAOImpl();
	private List<Meal> car = new ArrayList<Meal>();
	private OrderService orderService = new OrderServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MealServlet() {
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
		String pathInfo = request.getPathInfo();
		HttpSession session = request.getSession();
		if ("/index".equals(pathInfo)) {
			// 登录后进入
			// 默认查询第一种早餐分类下的餐品
			// 查询所有餐品类别
			List<BreakfastType> breakfastTypes = breakfastTypeDAO.findAll();
			session.setAttribute("breakfasttypes", breakfastTypes);// 页面显示
			int typeId = breakfastTypes.get(0).getId();// 数据库中第一种分类id
			// 查询第一种早餐分类餐品
			List<Meal> meals = mealDAO.findMealByType(typeId);
			session.setAttribute("currMeals", meals);
			List<LunchType> lunchTypes = lunchTypeDAO.findAll();
			session.setAttribute("lunchtypes", lunchTypes);
			List<DinnerType> dinnerTypes = dinnerTypeDAO.findAll();
			session.setAttribute("dinnertypes", dinnerTypes);
			response.sendRedirect(request.getContextPath() + "/index.jsp");

		}
		if ("/findByType".equals(pathInfo)) {
			// 按类别查询
			// 获取请求中类别
			int typeId = Integer.parseInt(request.getParameter("typeid"));
			List<Meal> meals = mealDAO.findMealByType(typeId);
			session.setAttribute("currMeals", meals);
			response.sendRedirect(request.getContextPath() + "/meals.jsp");
		}
		if ("/search".equals(pathInfo)) {
			// 按关键词模糊查询
			// request.setCharacterEncoding("UTF-8"); //字符转换
			String input = request.getParameter("input");
			if (!input.equals("")) {
				List<Meal> meals = mealDAO.findMealByKeyword(input);
				session.setAttribute("currMeals", meals);
				// List<BreakfastType> breakfastTypes = breakfastTypeDAO.findAll();
				// session.setAttribute("breakfasttypes", breakfastTypes);// 页面显示
				response.sendRedirect(request.getContextPath() + "/meals.jsp");
			} else {
				// List<BreakfastType> breakfastTypes = breakfastTypeDAO.findAll();
				// session.setAttribute("breakfasttypes", breakfastTypes);// 页面显示
				response.sendRedirect(request.getContextPath() + "/meals.jsp");
			}

		}
		if ("/addCar".equals(pathInfo)) {
			// 加入购物车
			int mid = Integer.parseInt(request.getParameter("mid"));
			Meal meal = mealDAO.findMeal(mid);
			car.add(meal);
			// 购物车保存在session
			session.setAttribute("car", car);
			response.sendRedirect(request.getContextPath() + "/meals.jsp");
		}
		if ("/pay".equals(pathInfo)) {// 结算请求
			double price = Double.parseDouble(request.getParameter("totalPrice"));
			User user = (User) session.getAttribute("currUser");
			Date date = new Date();
			String oid = "";
			// 唯一的订单编号
			oid = DateUtil.dateToString(date, "yyyyMMddHHmmss") + user.getId();
			Random random = new Random();
			for (int i = 0; i < 3; i++) {
				oid += random.nextInt(10);
			}

			// 下单时间
			String otime = DateUtil.dateToString(date, "yyyy-MM-dd HH:mm:ss");
			// 构造订单信息
			Order order = new Order(0, oid, user.getId(), price, otime);

			List<Meal> meals = new ArrayList<Meal>();// 订单详情中的书籍
			// 获取购物车页面勾选的书籍
			String[] mids = request.getParameterValues("mid");// 复选框的name属性
			List<Meal> car = (List<Meal>) session.getAttribute("car");
			// 构造订单详情
			for (String mid : mids) {
				int id = Integer.parseInt(mid);// 书籍id
				Meal meal = mealDAO.findMeal(id);// 要购买的书籍
				meals.add(meal);
				// 重置购物车。将购物车中已选商品删除
				for (int i = 0; i < car.size(); i++) {
					if (id == car.get(i).getId()) {// 这本书要购买，需要从购物车中删除
						car.remove(i);
					}
				}

			}
			// 重置购物车
			session.setAttribute("car", car);// car是新的购物车信息
			orderService.addOrder(order, meals);
			// 跳转到orderServlet 查询该用户所有历史订单
			response.sendRedirect(request.getContextPath() + "/order/selectByUser");
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
