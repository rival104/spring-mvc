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
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">

<title>Spring CRUD App</title>
</head>
<body>
	<!--Navbar -->
	<nav class="navbar navbar-expand-lg navbar-dark"
		style="background-color: #33B5E5;">
		<a class="navbar-brand" href="#">Nvdia</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="home">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="selectAll">View</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Select </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="selectForm">By Id</a> <a
							class="dropdown-item" href="selectByNameForm">By Name</a>
					</div></li>
				<li class="nav-item"><a class="nav-link" href="register">Register</a></li>
				<li class="nav-item"><a class="nav-link" href="update">Update</a></li>
				<li class="nav-item"><a class="nav-link" href="delete">Delete</a></li>
			</ul>

			<ul class="navbar-nav ml-auto my-2 my-lg-0">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <i class="fas fa-user"></i><span
						class="text-uppercase"> ${user}</span> Profile
				</a>

					<div class="dropdown-menu dropdown-menu-right dropdown-info"
						aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="#">My account</a>
						<div class="dropdown-divider"></div>
						<a id="formSubmit" class="dropdown-item formSubmit" href="#">Log
							out</a>
					</div></li>

			</ul>
		</div>
	</nav>
	<!--/.Navbar -->
	<div class="mt-30"></div>