package com.flyaway.bean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "booking")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_id")
	private long bookingId;
	@OneToOne(targetEntity = UserData.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private UserData user;
	@OneToOne(targetEntity = Flight.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "flight_id")
	private Flight flight;
	@Column(name = "total_ticket_price")
	private float totalTiketPrice;
	@Column(name = "departure_date")
	private String departureDate;
	@Column(name = "payment")
	private boolean payment;
	@Column(name = "no_of_tickets")
	private int totalNoOfTickets;

	public int getTotalNoOfTickets() {
		return totalNoOfTickets;
	}


	public void setTotalNoOfTickets(int totalNoOfTickets) {
		this.totalNoOfTickets = totalNoOfTickets;
	}


	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getDepartureDate() {
		return departureDate;
	}


	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}


	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public long getBookingId() {
		return bookingId;
	}
	
	public UserData getUser() {
		return user;
	}

	public void setUser(UserData user) {
		this.user = user;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public float getTotalTiketPrice() {
		return totalTiketPrice;
	}

	public void setTotalTiketPrice(float totalTiketPrice) {
		this.totalTiketPrice = totalTiketPrice;
	}

	public boolean isPayment() {
		return payment;
	}

	public void setPayment(boolean payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", user=" + user + ", flight=" + flight + ", totalTiketPrice="
				+ totalTiketPrice + ", departureDate=" + departureDate + ", payment=" + payment + "]";
	}

}
