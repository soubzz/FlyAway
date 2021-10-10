<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.flyaway.bean.Flight"%>
<%@page import="com.flyaway.bean.Airline"%>
<%@page import="com.flyaway.bean.Location"%>
<%@page import="com.flyaway.dao.AirlineDao"%>
<%@page import="com.flyaway.dao.AirlineImplementationDao"%>
<%@page import="com.flyaway.dao.LocationDao"%>
<%@page import="com.flyaway.dao.LocationDaoImpl"%>
<%@page import="com.flyaway.dao.FlightDao"%>
<%@page import="com.flyaway.dao.FlightDaoImpl"%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<title>Admin Home</title>
<style type="text/css">
.container {
	margin-top: 50px;
	background-color: white;
	padding: 10px;
}

body {
	background-image:
		url("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQTNfHQ21fzoWWt2DxEGA_1sNdUSEsn6xzvZW9nSH47NDW_HdW6&s");
	/* Full height */
	height: 100%;
	max-width: 1200px;
	/* Center and scale the image nicely */
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
</head>
<script language="javascript" type="text/javascript">
	function call() {
		document.getElementById("test").style.display = "none";
	}
</script>
<body>
	<div class="container">
		<div class="h3 text-center">Admin Home Screen</div>
		<div align="right">
		<a href="/FlyAway/change-password.jsp" class="btn btn-primary">Change Password</a>
		</div>
		<div class="container">
			<div class="row">
				<div class="col">
					<div id="airline">
						<div class="row">
							<div class="col-4">
								<h4 class="text-center">Add Airline</h4>
								<div id="airline">
									<form action="airline" method="post">
										<div class="mb-3">
											<label class="form-label">Airline Name</label> <input
												type="text" class="form-control" placeholder="Airline"
												name="airline">
										</div>
										<button type="submit" class="btn btn-primary">Submit</button>
									</form>
								</div>
							</div>
							<div class="col-8">
								<div align="center">
									<%
									AirlineDao airlineDao = new AirlineImplementationDao();
									List<Airline> listOfAirlines = airlineDao.getAllAirline();
									%>

									<h4 class="text-center">List of Airlines</h4>

									<table class="table">

										<tr>
											<th>Airline ID</th>
											<th>AirLine Name</th>
											<th>Edit</th>
											<th>Delete</th>
										</tr>
										<%
										// Iterating through subjectList

										if (listOfAirlines != null) // Null check for the object
										{
											Iterator<Airline> iterator = listOfAirlines.iterator(); // Iterator interface

											while (iterator.hasNext()) // iterate through all the data until the last record
											{
												Airline airline = iterator.next(); //assign individual employee record to the employee class object
										%>
										<tr>
											<td><%=airline.getAirlineId()%></td>
											<td><%=airline.getAirlineName()%></td>
											<td><a href="edit?id=<%=airline.getAirlineId()%>">Edit</a></td>
											<td><a href="delete?id=<%=airline.getAirlineId()%>">Delete</a></td>
										</tr>
										<%
										}
										}
										%>
									</table>
								</div>

							</div>
						</div>


					</div>

					<div id="location">



						<div class="row">
							<div class="col-4">
								<h4 class="text-center">Add Location</h4>
								<form action="location" method="post">
									<div class="mb-3">
										<label class="form-label">Source location</label> <input
											type="text" class="form-control" placeholder="Source"
											name="source"> <label class="form-label">Destination
											location</label> <input type="text" class="form-control"
											placeholder="Destination" name="destination">
									</div>
									<button type="submit" class="btn btn-primary">Submit</button>
								</form>
							</div>
							<div class="col-8">
								<div align="center">
									<%
									LocationDao locationDao = new LocationDaoImpl();
									List<Location> listOfLocations = locationDao.getAllLocations();
									%>

									<h4 class="text-center">List of Locations</h4>

									<table class="table">

										<tr>
											<th>Location ID</th>
											<th>Source</th>
											<th>Destination</th>
											<th>Edit</th>
											<th>Delete</th>
										</tr>
										<%
										// Iterating through subjectList

										if (listOfLocations != null) // Null check for the object
										{
											Iterator<Location> iterator = listOfLocations.iterator(); // Iterator interface

											while (iterator.hasNext()) // iterate through all the data until the last record
											{
												Location location = iterator.next();
										%>
										<tr>
											<td><%=location.getLocationId()%></td>
											<td><%=location.getSource()%></td>
											<td><%=location.getDestination()%></td>
											<td><a href="edit?id=<%=location.getLocationId()%>">Edit</a></td>
											<td><a href="delete?id=<%=location.getLocationId()%>">Delete</a></td>
										</tr>
										<%
										}
										}
										%>
									</table>
								</div>

							</div>
						</div>

					</div>

					<div></div>
				</div>
			</div>
		</div>

	</div>

	<div class="container">
		<div id="flight">

			<div class="row">
				<div class="col-4">
					<h4 class="text-center">Flight</h4>
					<form action="location" method="post">
						<div class="mb-3">
							<label class="form-label">Airline</label> 
							<select id="airline"
								name="airlineId" class="form-select">
								<%
								// Iterating through subjectList

								if (listOfAirlines != null) // Null check for the object
								{
									Iterator<Airline> iterator = listOfAirlines.iterator(); // Iterator interface

									while (iterator.hasNext()) // iterate through all the data until the last record
									{
										Airline airline = iterator.next(); //assign individual employee record to the employee class object
								%>
								<%-- <c:forEach var="airline" items="${listOfAirlines}"> --%>
									<option value=<%= airline.getAirlineId() %>><%= airline.getAirlineName() %></option>
								<%-- </c:forEach> --%>
								<%
								}
								}
								%>
							</select> 
							<label class="form-label">Source</label> 
							<select id="source"
								name="sourceId" class="form-select">
								<%
								// Iterating through subjectList

								if (listOfLocations != null) // Null check for the object
								{
									Iterator<Location> iterator = listOfLocations.iterator(); // Iterator interface

									while (iterator.hasNext()) // iterate through all the data until the last record
									{
										Location location = iterator.next(); //assign individual employee record to the employee class object
								%>
									<option value=<%= location.getLocationId() %>><%= location.getSource() %></option>
								<%
								}
								}
								%>
							</select> 
							<label class="form-label">Destination</label> 
							<select id="destination"
								name="destination" class="form-select">
								<%
								// Iterating through subjectList

								if (listOfLocations != null) // Null check for the object
								{
									Iterator<Location> iterator = listOfLocations.iterator(); // Iterator interface

									while (iterator.hasNext()) // iterate through all the data until the last record
									{
										Location location = iterator.next(); //assign individual employee record to the employee class object
								%>
									<option value=<%= location.getLocationId() %>><%= location.getDestination() %></option>
								<%
								}
								}
								%>
							</select>
							<label class="form-label">Price per ticket</label> <input
											type="number" class="form-control" placeholder="Source"
											name="source">
							<label class="form-label">No of Seats</label> <input
											type="number" class="form-control" placeholder="Source"
											name="source">
						</div>
						<button type="submit" class="btn btn-primary">Submit</button>
					</form>
				</div>
				<div class="col-8">
					<div align="center">
						<%
						FlightDao flightDao = new FlightDaoImpl();
						List<Flight> listOfFlights = flightDao.getAllFlights();
						%>

						<h4 class="text-center">List of Flights</h4>

						<table class="table">

							<tr>
								<th>Flight Number</th>
								<th>Airline</th>
								<th>Source</th>
								<th>Destination</th>
								<th>Total Seats</th>
								<th>Price per Ticket</th>
								<th>Edit</th>
								<th>Delete</th>

							</tr>
							<%
							// Iterating through subjectList

							if (listOfFlights != null) // Null check for the object
							{
								Iterator<Flight> iterator = listOfFlights.iterator(); // Iterator interface

								while (iterator.hasNext()) // iterate through all the data until the last record
								{
									Flight flight = iterator.next();
							%>
							<tr>
								<td><%=flight.getFlightId()%></td>
								<td><%=flight.getAirline().getAirlineName()%></td>
								<td><%=flight.getLocation().getSource()%></td>
								<td><%=flight.getLocation().getDestination()%></td>
								<td><%=flight.getSeats()%></td>
								<td><%=flight.getPricePerTicket()%></td>
								<td><a href="edit?id=<%=flight.getFlightId()%>">Edit</a></td>
								<td><a href="delete?id=<%=flight.getFlightId()%>">Delete</a></td>
							</tr>
							<%
							}
							}
							%>
						</table>
					</div>

				</div>
			</div>

		</div>

	</div>

	<%-- <c:if test="${true == name}">
			<ul>
				<li><a href="servletName">MyfirstSubmenu</a></li>
				<li><a href="servletName1">MyfirstSubmenu1</a></li>
			</ul>
		</c:if> --%>


	<!-- <div id="flight">
			<form action="flight" method="post">
				<div class="mb-3">
					<label class="form-label"></label> <input type="text"
						class="form-control" placeholder="" name="airline">
				</div>
				<div class="mb-3">
					<label class="form-label"></label> <input type="text"
						class="form-control" placeholder="Airline" name="airline">
				</div>
				<button type="submit" class="btn btn-primary">Submit</button>
			</form>
		</div> -->

	<!-- Optional JavaScript; choose one of the two! -->

	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>

	<!-- Option 2: Separate Popper and Bootstrap JS -->
	<!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    -->
</body>
</html>