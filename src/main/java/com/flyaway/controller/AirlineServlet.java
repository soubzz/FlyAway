package com.flyaway.controller;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyaway.bean.Airline;
import com.flyaway.dao.AirlineDao;
import com.flyaway.dao.AirlineImplementationDao;


/**
 * Servlet implementation class AirlineServlet
 */
@WebServlet("/admin-dashboard/airline")
public class AirlineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AirlineDao airlineDao = new AirlineImplementationDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AirlineServlet() {
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
		String airlineName = request.getParameter("airline");
		airlineDao.addAirline(airlineName);
	}

}
