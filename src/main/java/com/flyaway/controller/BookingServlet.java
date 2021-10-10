package com.flyaway.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flyaway.bean.Booking;
import com.flyaway.bean.Flight;
import com.flyaway.bean.SearchForm;
import com.flyaway.dao.BookingDao;
import com.flyaway.dao.BookingDaoImpl;
import com.flyaway.dao.FlightDao;
import com.flyaway.dao.FlightDaoImpl;

/**
 * Servlet implementation class BookingServlet
 */
@WebServlet("/booking")
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BookingDao bookingDao = new BookingDaoImpl();
	FlightDao flightDao = new FlightDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		long flightId = Long.parseLong(request.getParameter("flightid"));
		Flight flight = flightDao.getFlight(flightId);
		SearchForm search = (SearchForm) request.getSession().getAttribute("searchForm");
		search.setSelectedFlight(flight);
		search.setTotalTicketPrice(flight.getPricePerTicket()*search.getNoOfTickets());
		request.getSession().setAttribute("searchForm", search);
		
		response.sendRedirect(request.getContextPath()+"/registration-form.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
