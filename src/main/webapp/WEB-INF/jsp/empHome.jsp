<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<script src="https://kit.fontawesome.com/abc39c0b8a.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">

<title>Spring CRUD App</title>
</head>
<body>
	<!--Navbar -->
	<nav class="navbar navbar-expand-lg navbar-dark"
		style="background-color: #495057;">
		<a class="navbar-brand" href="#">Nvdia</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="empHome">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="viewEmployee">View</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Update</a></li>
			</ul>

			<ul class="navbar-nav ml-auto my-2 my-lg-0">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <i class="fas fa-user"></i><span
						class="text-uppercase"> ${user.username}</span> Profile
				</a>

					<div class="dropdown-menu dropdown-menu-right dropdown-info"
						aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="#">My account</a>
						<div class="dropdown-divider"></div>
						<a id="formSubmit" class="dropdown-item formSubmit" href="logout">Log
							out</a>
					</div></li>

			</ul>
		</div>
	</nav>
	<!--/.Navbar -->
	<div class="mt-30"></div>
	<div class="container">
		<div class="row">
			<div class="jumbotron">
				<h1 class="display-4">Welcome ${username}!</h1>
				<p class="lead">This is a Spring JAVA Web Application that
					utilizes interceptor to provide role specific tasks.</p>
				<hr class="my-4">
				<p>It perform the following functions the performs the operation
					in a database.</p>

				<div class="row">
					<div class="col-sm-6">
						<div class="card text-white bg-info mb-3">
							<div class="card-body">
								<h5 class="card-title">View Your Info</h5>
								<p class="card-text">Uses SQL queries using MySql Driver
									manger to get the employee details</p>
								<a href="viewEmployee" class="btn btn-dark">View</a>
							</div>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="card text-white bg-success mb-3">
							<div class="card-body">
								<h5 class="card-title">Update Your Info</h5>
								<p class="card-text">Uses SQL queries update the particular
									employee using ID. It uses relational db to acheive it.</p>
								<a href="#" class="btn btn-dark">Update</a>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>