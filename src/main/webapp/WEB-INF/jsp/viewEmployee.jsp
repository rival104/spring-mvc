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
			<h2>Displaying ${emp.name} Info</h2>
		</div>

		<div class="portfoliocard">
			<div class="coverphoto"></div>
			<div class="row">

				<c:if test="${emp != null}">
					<c:set var="gender" scope="session" value="" />

					<c:choose>
						<c:when test="${emp.gender == 'male'}">
							<c:set var="gender" scope="session" value="men" />
						</c:when>

						<c:when test="${emp.gender == 'female'}">
							<c:set var="gender" scope="session" value="women" />
						</c:when>
					</c:choose>

					<c:set var="profileLink" scope="session"
						value="https://randomuser.me/api/portraits/${gender}/${emp.id % 100}.jpg" />
				</c:if>

				<img class="profile_picture" alt="" src="${profileLink}">
				<div class="col-md-3 left_col">
					<div class="followers">
						<div class="follow_count">${emp.sal}</div>
						Salary
					</div>
					<div class="following">
						<div class="follow_count">${emp.phone}</div>
						Contact
					</div>
				</div>
				<div class="col-md-9 right_col">
					<div class="row">
						<div class="col-sm-10">
							<h2 class="name">
								<span class="text-capitalize">${emp.name}</span>
							</h2>
							<h3 class="location">
								<span class="text-capitalize">${emp.designation}</span>
							</h3>
						</div>
						<div class="col-sm-2">
							<input type="submit" class="profile-edit-btn" name="btnAddMore"
								value="Edit Profile" />
						</div>
					</div>

					<div class="row">
						<div class="col-12">
							<div class="profile-head">
								<ul class="nav nav-tabs justify-content-end" id="myTab"
									role="tablist">
									<li class="nav-item"><a class="nav-link active"
										id="home-tab" data-toggle="tab" href="#home" role="tab"
										aria-controls="home" aria-selected="true">About</a></li>
									<li class="nav-item"><a class="nav-link" id="profile-tab"
										data-toggle="tab" href="#profile" role="tab"
										aria-controls="profile" aria-selected="false">Timeline</a></li>
								</ul>
							</div>
						</div>
					</div>
					<div class="row mt-30 justify-content-center">
						<div class="col-2"></div>
						<div class="col-10">
							<div class="tab-content profile-tab" id="myTabContent">
								<div class="tab-pane fade show active" id="home" role="tabpanel"
									aria-labelledby="home-tab">
									<div class="row">
										<div class="col-md-2">
											<label>User Id:</label>
										</div>
										<div class="col-md-4">
											<p>${emp.id}</p>
										</div>
										<div class="col-md-2">
											<label>Name:</label>
										</div>
										<div class="col-md-4">
											<p>${emp.name}</p>
										</div>
										<div class="col-md-2">
											<label>Email:</label>
										</div>
										<div class="col-md-4">
											<p>${emp.email}</p>
										</div>

										<div class="col-md-2">
											<label>Type:</label>
										</div>
										<div class="col-md-4">
											<p>${emp.empType}</p>
										</div>

										<div class="col-md-2">
											<label>DOB:</label>
										</div>
										<div class="col-md-4">
											<p>${emp.dob}</p>
										</div>

										<div class="col-md-2">
											<label>Gender:</label>
										</div>
										<div class="col-md-4">
											<p>${emp.gender}</p>
										</div>

										<div class="col-md-2">
											<label>Role:</label>
										</div>
										<div class="col-md-4">
											<p>${emp.role}</p>
										</div>

										<div class="col-md-2">
											<label>Tech Stack:</label>
										</div>
										<div class="col-md-4">
											<p>
												<span class="badge badge-success">${emp.techStack}</span>
											</p>
										</div>
									</div>
								</div>
								<div class="tab-pane fade" id="profile" role="tabpanel"
									aria-labelledby="profile-tab">
									<div class="row">
										<div class="col-md-6">
											<label>Experience</label>
										</div>
										<div class="col-md-6">
											<p>Expert</p>
										</div>
									</div>
									<div class="row">
										<div class="col-md-6">
											<label>Hourly Rate</label>
										</div>
										<div class="col-md-6">
											<p>10$/hr</p>
										</div>
									</div>
									<div class="row">
										<div class="col-md-6">
											<label>Total Projects</label>
										</div>
										<div class="col-md-6">
											<p>230</p>
										</div>
									</div>
									<div class="row">
										<div class="col-md-6">
											<label>English Level</label>
										</div>
										<div class="col-md-6">
											<p>Expert</p>
										</div>
									</div>
									<div class="row">
										<div class="col-md-6">
											<label>Availability</label>
										</div>
										<div class="col-md-6">
											<p>6 months</p>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12">
											<label>Your Bio</label><br />
											<p>Your detail description</p>
										</div>
									</div>
								</div>
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