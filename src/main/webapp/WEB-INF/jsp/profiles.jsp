<%@ include file="header.jsp"%>
<form action="getProfileByName" id="viewProfile">
	<input type="hidden" name="ename" id="empNameForProfile">
</form>

<div class="container">
	<div class="row">
		<h2>Display Employee Info</h2>
		<div class="ml-auto p-0">
			<select onchange="getSelectedOption()" id="selectEmp">
				<option selected disabled>Show Employee</option>
				<c:forEach items="${names}" var="name">
					<option value="${name}">${name}</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="portfoliocard">
		<div class="coverphoto"></div>
		<div class="row">

			<div class="profile_picture"></div>
			<div class="left_col">
				<div class="followers">
					<div class="follow_count">${emp.sal}</div>
					Salary
				</div>
				<div class="following">
					<div class="follow_count">${emp.phone}</div>
					Contact
				</div>
			</div>
			<div class="right_col">
				<div class="row">
					<div class="col-md-10">
						<h2 class="name"><span class="text-capitalize">${emp.name}</span></h2>
						<h3 class="location"><span class="text-capitalize">${emp.designation}</span></h3>
					</div>
					<div class="col-md-2">
						<input type="submit" class="profile-edit-btn" name="btnAddMore"
							value="Edit Profile" />
					</div>
				</div>

				<div class="row">
					<div class="col-md-12">
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
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-10">
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
										<label>Tech Stack</label>
									</div>
									<div class="col-md-4">
										<p>${emp.techStack}</p>
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

<%@ include file="footer.jsp"%>