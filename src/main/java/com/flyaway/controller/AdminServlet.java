package com.flyaway.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flyaway.bean.UserData;
import com.flyaway.dao.UserDataDao;
import com.flyaway.dao.UserDataDaoImpl;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDataDao userDataDao = new UserDataDaoImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.sendRedirect(request.getContextPath() + "/index.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("changepassword") != null && (Boolean.parseBoolean(request.getParameter("changepassword")) == true)) {
			changePassword(request, response);
		}
		if (request.getParameter("login") != null && (Boolean.parseBoolean(request.getParameter("login")) == true)) {
			System.out.println("Hello");
			adminLogin(request, response);
		}
	}

	protected void changePassword(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String password = request.getParameter("new_password");
		UserData admin = (UserData) request.getSession().getAttribute("admin-login");
		admin.setPassword(password);
		userDataDao.updateUser(admin);
		response.sendRedirect("password-confirmation.jsp");

	}

	protected void adminLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("emailId");
		String password = request.getParameter("password");
		List<UserData> userList = userDataDao.getAllUser();
		HttpSession session = request.getSession();
		boolean isLogin = false;
		for (UserData userData : userList) {
			if (userData.getEmail().equals(email) && userData.getPassword().equals(password) && userData.getUserType().equals("admin")) {
				System.out.println("Login Success");
				isLogin = true;
				session.setAttribute("admin-login", userData);
				break;
			} 
		}
		if(isLogin) response.sendRedirect(request.getContextPath() + "/admin-dashboard.jsp");
		else System.out.println("Login not possible");
		
		
	}

}
