<%@ include file="header.jsp"%>

<div class="container">
	<c:if test="${isRegistered}">
		<div class="row justify-content-center">
			<div class="alert alert-success alert-dismissible fade show"
				role="alert">
				<strong>Registered successfully!</strong> <a href="selectAll">click
					here</a> to view employees
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</div>
	</c:if>

	<c:if test="${hasError}">
		<div class="row justify-content-center">
			<div class="alert alert-danger alert-dismissible fade show"
				role="alert">
				<strong>Error registering employee! </strong> check input and try
				again.
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</div>
	</c:if>


	<div class="register">
		<div class="row">

			<div class="col-md-3 register-left">
				<img src="https://i.ibb.co/84sRCCv/kissclipart-follower-icon-instagram-icon-profile-icon-6c80833fc4205af7-1.png" alt="" />
				<h3>Welcome</h3>
				<p>Register an new Employee or assign an user in just a few steps!</p>
			</div>

			<div class="col-md-9 register-right">
				<ul class="nav nav-tabs nav-justified" id="myTab" role="tablist">
					<li class="nav-item"><a class="nav-link active" id="home-tab"
						data-toggle="tab" href="#home" role="tab" aria-controls="home"
						aria-selected="true">Employee</a></li>
					<li class="nav-item"><a class="nav-link" id="profile-tab"
						data-toggle="tab" href="#profile" role="tab"
						aria-controls="profile" aria-selected="false">User</a></li>
				</ul>

				<div class="tab-content" id="myTabContent">
					<div class="tab-pane fade show active" id="home" role="tabpanel"
						aria-labelledby="home-tab">
						<h3 class="register-heading">Register an Employee</h3>
						<form action="register" autocomplete="off" method="post">
							<div class="row register-form">
								<div class="col-md-6">
									<div class="form-group">
										<input type="text" class="form-control" name="name"
											placeholder="Full Name *" value="" required />
									</div>
									<div class="form-group">
										<input type="number" class="form-control" name="sal"
											placeholder="Salary *" value="" required />
									</div>
									<div class="form-group">
										<input type="text" class="form-control" name="empType"
											placeholder="Type eg.Fulltime *" value="" />
									</div>
									<div class="form-group">
										<input type="text" class="form-control" name="designation"
											placeholder="designation eg. Manager *" value="" />
									</div>
									<div class="form-group"></div>
									<div class="form-group">
										<div class="maxl">
											<label class="radio inline"> <input type="radio"
												name="gender" value="male" checked> <span>
													Male </span>
											</label> <label class="radio inline"> <input type="radio"
												name="gender" value="female"> <span>Female </span>
											</label> <label class="radio inline"> <input type="radio"
												name="gender" value="other"> <span>Other </span>
											</label>
										</div>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<input type="email" class="form-control" name="email"
											placeholder="Employee Email *" value="" />
									</div>
									<div class="form-group">
										<input type="text" minlength="10" maxlength="15" name="phone"
											class="form-control" placeholder="Your Phone *" value="" />
									</div>
									<div class="form-group">
										<select class="form-control text-capitalize" name="role">
											<option class="hidden" selected disabled>Please
												Select User Role</option>
											<option>employee</option>
											<option>hr</option>
										</select>
									</div>
									<div class="form-group">
										<select class="form-control text-capitalize" name="techStack">
											<option class="hidden" selected disabled>Please
												Select Specialization</option>
											<option>java</option>
											<option>python</option>
											<option>communication</option>
										</select>
									</div>
									<div class="form-group">
										<input type="date" class="form-control" name="dob"
											placeholder="Enter Date of Birthk *" value="" />
									</div>
									<input type="submit" class="btnRegister" value="Register" />
								</div>

							</div>
						</form>
					</div>

					<div class="tab-pane fade show" id="profile" role="tabpanel"
						aria-labelledby="profile-tab">
						<h3 class="register-heading">Register a User</h3>
						<div class="row register-form">
							<div class="col-md-6">
								<div class="form-group">
									<input type="text" class="form-control" name="username"
										placeholder="User Name *" value="" />
								</div>
								<div class="form-group">
									<input type="password" class="form-control"
										placeholder="Password *" value="" />
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<select class="form-control" name="userByName">
										<option class="hidden" selected disabled>Please
											select employee details</option>
										<c:forEach items="${names}" var="name">
											<option value="${name}">${name}</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-group">
									<input type="password" class="form-control" name="password"
										placeholder="Confirm Password *" value="" />
								</div>
								<input type="submit" class="btnRegister" value="Register" />
							</div>
						</div>
					</div>

				</div>
			</div>

		</div>
	</div>

</div>

<%@ include file="footer.jsp"%>