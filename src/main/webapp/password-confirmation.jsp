<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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

<%
LocationDao locationDao = new LocationDaoImpl();
List<Location> listOfLocations = locationDao.getAllLocations();
%>

<title>Password Confirmation</title>
<style type="text/css">
.container {
	margin-top: 70px;
	background-color: white;
	padding: 10px;
	margin-bottom: 50px;
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
<body>
	<div class="container">
		<div class="container">
			<div class="row">
				<div class="col">
				<div class="h1 text-center" style="color: #0eb1e6">FlyAway</div>
					<br>
					<div class="h3" style="font-family:cursive;">Your password has been changed Successfully!!</div>
					<div class="h6" style="font-family:cursive;"> To return to Admin Screen, Click <a href="/FlyAway/admin-dashboard.jsp">here</a></div>
				</div>
				
			</div>
		</div>

	</div>

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