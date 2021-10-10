package com.flyaway.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyaway.bean.SearchForm;
import com.flyaway.bean.UserData;
import com.flyaway.dao.UserDataDao;
import com.flyaway.dao.UserDataDaoImpl;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDataDao userDao = new UserDataDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserData user = new UserData();
		user.setUserName(request.getParameter("userName"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setGender(request.getParameter("gender"));
		user.setAge(Integer.parseInt(request.getParameter("age")));
		userDao.saveUser(user);
		SearchForm search = (SearchForm) request.getSession().getAttribute("searchForm");
		search.setUser(user);
		request.getSession().setAttribute("searchForm", search);
		response.sendRedirect("booking-confirmation.jsp");
		
	}

}
