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



	<div class="row justify-content-center">
		<!--Custom Material form -->
		<div class="card min-w">
			<h5 class="card text-white bg-info mb-3 card-header text-center py-4">
				<strong>Register New Employee</strong>
			</h5>
			<!--Card content-->
			<div class="card-body px-lg-5 pt-0">
				<!-- Form -->
				<form class="text-center" style="color: #757575;" action="register"
					autocomplete="off" method="post">
					<!-- ID -->
					<div class="md-form">
						<input type="number" class="form-control" id="employeeId" name="id"
							placeholder="Enter ID here" required> <label for="employeeId">Employee
							ID</label>
					</div>
					<!-- Name -->
					<div class="md-form">
						<input type="text" class="form-control" id="employeeName"
							name="name" placeholder="Enter Name here"> <label
							for="employeeName">Name</label>
					</div>
					<!-- Salary -->
					<div class="md-form">
						<input type="number" class="form-control" id="employeeSal"
							name="sal" placeholder="Enter Salary here"> <label
							for="employeeSal">Salary</label>
					</div>
					<!-- button -->
					<button
						class="btn btn-outline-info btn-rounded btn-block my-4 waves-effect z-depth-0"
						type="submit">Register</button>
					<a
						class="btn btn-outline-secondary btn-rounded btn-block my-4 waves-effect z-depth-0"
						href="home" role="button">Go Back</a>
				</form>
				<!-- Form -->
			</div>
		</div>
		<!--Custom Material form -->
	</div>

</div>

<%@ include file="footer.jsp"%>