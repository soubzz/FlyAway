package com.flyaway.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyaway.bean.Booking;
import com.flyaway.bean.SearchForm;
import com.flyaway.dao.BookingDao;
import com.flyaway.dao.BookingDaoImpl;

/**
 * Servlet implementation class PaymentServlet
 */
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BookingDao bookingDao = new BookingDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentServlet() {
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
		Booking booking = new Booking();
		SearchForm search = (SearchForm) request.getSession().getAttribute("searchForm");
		booking.setUser(search.getUser());
		booking.setFlight(search.getSelectedFlight());
		booking.setDepartureDate(search.getDate());
		booking.setTotalTiketPrice(search.getTotalTicketPrice());
		booking.setPayment(true);
		booking.setTotalNoOfTickets(search.getNoOfTickets());
		bookingDao.saveBooking(booking);
		response.sendRedirect("payment-confirmation.jsp");
	}

}
