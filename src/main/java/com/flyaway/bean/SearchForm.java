package com.flyaway.bean;

import java.util.Date;
import java.util.List;

public class SearchForm {

	private String source;
	private String destination;
	private String date;
	private int noOfTickets;
	private List<Flight> filteredFlights;
	private float totalTicketPrice;
	private Flight selectedFlight;
	private UserData user;

	public UserData getUser() {
		return user;
	}

	public void setUser(UserData user) {
		this.user = user;
	}

	public Flight getSelectedFlight() {
		return selectedFlight;
	}

	public void setSelectedFlight(Flight selectedFlight) {
		this.selectedFlight = selectedFlight;
	}

	public SearchForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getNoOfTickets() {
		return noOfTickets;
	}

	public void setNoOfTickets(int noOfTickets) {
		this.noOfTickets = noOfTickets;
	}

	public List<Flight> getFilteredFlights() {
		return filteredFlights;
	}

	public void setFilteredFlights(List<Flight> filteredFlights) {
		this.filteredFlights = filteredFlights;
	}

	public float getTotalTicketPrice() {
		return totalTicketPrice;
	}

	public void setTotalTicketPrice(float totalTicketPrice) {
		this.totalTicketPrice = totalTicketPrice;
	}

	@Override
	public String toString() {
		return "SearchForm [source=" + source + ", destination=" + destination + ", date=" + date + ", noOfTickets="
				+ noOfTickets + ", filteredFlights=" + filteredFlights + ", totalTicketPrice=" + totalTicketPrice
				+ ", selectedFlight=" + selectedFlight + "]";
	}

}
