<%@page import="org.apache.tomcat.jni.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.flyaway.bean.SearchForm"%>
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
SearchForm search = (SearchForm) request.getSession().getAttribute("searchForm");
%>
<title>Payment Confirmation</title>
<style type="text/css">
.container {
	margin-top: 120px;
	background-color: white;
	padding: 50px;
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
		<div class="row">
			<div class="col">
				<div>
					<div class="h1 text-center" style="color: #0eb1e6">FlyAway - Payment Confirmation</div>
					<br>
					<div class="card">
						<div class="card-header">Booking Confirmation</div>
						<div class="card-body">
							<h5 class="card-title">Booking Details</h5>
							<p class="card-text h6">
								Airline:
								<%=search.getSelectedFlight().getAirline().getAirlineName()%></p>
							<p class="card-text">
								<span class="float-start">From: <%=search.getSource()%></span> <span
									class="float-end">To: <%=search.getDestination()%></span>
							</p>
							<br>
							<p>
								<span>Date: <%=search.getDate()%></span>
							</p>
						</div>
						<div >
							<div class="accordion" id="accordionPanelsStayOpenExample">
								<div class="accordion-item">
									<h2 class="accordion-header" id="panelsStayOpen-headingOne">
										<button class="accordion-button" type="button"
											data-bs-toggle="collapse"
											data-bs-target="#panelsStayOpen-collapseOne"
											aria-expanded="true"
											aria-controls="panelsStayOpen-collapseOne">
											Passenger Details</button>
									</h2>
									<div id="panelsStayOpen-collapseOne"
										class="accordion-collapse collapse show"
										aria-labelledby="panelsStayOpen-headingOne">
										<div class="accordion-body">
											<p class="card-text h5">
												<span class="float-start"><%=search.getUser().getUserName()%></span>
												<span class="float-end">Ticket Status</span>
											</p>
											<br>
											<p class="card-text">
												<span class="float-start"><%=search.getUser().getGender()%>|<%=search.getUser().getAge()%></span>
												<span class="float-end">Confirmed</span>
											</p>
											<br>

										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<br>
					<div>
						<form action="/payment-confirmation">
							<div class="card mb-3">
								<div class="row g-0">
									<div class="col-md-8">
										<div class="card-body">
											<h5 class="card-title">Payment Completed</h5>
											<p class="card-text h6">
												No of Seats:
												<%=search.getNoOfTickets()%></p>
											<p class="card-text h6">
												Total Paid: <span class="h5"><%=search.getTotalTicketPrice()%></span>
											</p>
										</div>
									</div>
									<div class="col-md-4">
										<br>
										<!-- <div class="mb-3">
											<button class="btn btn-info" type="submit" style="width: 100px">Proceed to the Payment screen</button>
										</div>
										<div class="mb-3">
											<button class="btn btn-warning" type="button" style="width: 100px">Cancel</button>
										</div> -->
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			<div class="col-6 text-center" style="margin-top: 90px">
					<br>
					<div class="text-center">Click <a href="/FlyAway/index.jsp">Here</a> to return to Main page</div>
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