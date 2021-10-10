<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/css/bootstrap.min.css" integrity="sha384-y3tfxAZXuh4HwSYylfB+J125MxIs6mR5FOHamPBG064zB+AFeWH94NdvaCBm8qnd" crossorigin="anonymous">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<title>Fly Away Portal</title>
<style>
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

.bg {
	/* The image used */
	position: relative;
	left: 150px;
	top: 200px;
}
</style>
</head>
<body>
	<div class="bg">
		<div class="h1" style="color: #EFEFEF">FlyAway</div>
		<br>
		<!-- <button class="btn btn-light btn-lg">
			<a href="/FlyAway/search-form.jsp" style="color: #001E6C">Book Flight</a>
		</button>
		<button class="btn btn-light btn-lg">
			<a href="/FlyAway/admin-login.jsp" style="color: #001E6C">Admin Login</a>
		</button> -->
  <div style="padding-left: 20%; padding-bottom: 25%"class="card-deck">
  <div class="card" style="width: 18rem;">
    <img class="card-img-top" src="img/tickets.jfif" alt="Card image cap" height="180" width="300">
    <div style="padding: 10px" class="card-body">
      <h5 align="left" class="card-title"><b>Booking Flights</b></h5>
      <p align="left" class="card-text">This feature allows thw user to book flights</p>
      <a href="/FlyAway/search-form.jsp" class="btn btn-primary">Go>>></a>
    </div>
  </div>
  <div class="card" style="width: 18rem;">
    <img class="card-img-top" src="img/admin.jfif" alt="Card image cap" height="180" width="300">
    <div style="padding: 10px" class="card-body">
      <h5 align="left" class="card-title"><b>Admin Portal</b></h5>
      <p align="left" class="card-text">This feature allows admin to change passwords and perform back-end operations</p>
     <a href="/FlyAway/admin-login.jsp" class="btn btn-primary">Go>>></a>
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