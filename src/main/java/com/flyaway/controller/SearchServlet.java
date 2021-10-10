package com.flyaway.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flyaway.bean.Flight;
import com.flyaway.bean.SearchForm;
import com.flyaway.dao.FlightDao;
import com.flyaway.dao.FlightDaoImpl;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FlightDao flightDao = new FlightDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
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
		HttpSession session = request. getSession();
		SearchForm search = new SearchForm();
		search.setSource(request.getParameter("source"));
		search.setDestination(request.getParameter("destination"));
		search.setDate(request.getParameter("date"));	
		search.setNoOfTickets(Integer.parseInt(request.getParameter("no_of_tickets")));
		List<Flight> listOfFlights = flightDao.getAllFlights();
		List<Flight> filteredFlights = new ArrayList<Flight>();
		for (Flight flight : listOfFlights) {
			if(flight.getLocation().getSource().equals(search.getSource()) && flight.getLocation().getDestination().equals(search.getDestination())) {
				filteredFlights.add(flight);
			}
		}
		search.setFilteredFlights(filteredFlights);
		session.setAttribute("searchForm", search);
		
		request.getRequestDispatcher("book-flight.jsp").forward(request, response);
//		response.sendRedirect(request.getContextPath()+"/booking-details.jsp");
		
	}

}
