package com.flyaway.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "flight")
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "flight_id")
	private long flightId;

	@ManyToOne(targetEntity = Location.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "location_id")
	private Location location;

	@Column(name = "price_per_ticket")
	private float pricePerTicket;

	@OneToOne(targetEntity = Airline.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "airline_id")
	private Airline airline;
	
	@Column(name = "seats")
	private int seats;

	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public void setFlightId(long flightId) {
		this.flightId = flightId;
	}

	public long getFlightId() {
		return flightId;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public float getPricePerTicket() {
		return pricePerTicket;
	}

	public void setPricePerTicket(float pricePerTicket) {
		this.pricePerTicket = pricePerTicket;
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", location=" + location + ", pricePerTicket=" + pricePerTicket
				+ ", airline=" + airline + ", seats=" + seats + "]";
	}

}
