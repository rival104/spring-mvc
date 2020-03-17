<%@ include file="header.jsp"%>
<div class="container">
	<div class="row">
		<div class="jumbotron">
			<h1 class="display-4">Employee CRUD Function</h1>
			<p class="lead">This is a simple JAVA Servlet Web Application
				that utilizes Create, Update, Delete, Select (Read) operation on my
				sql database in a MVC architecture.</p>
			<hr class="my-4">
			<p>It perform the following functions the performs the operation
				in a database.</p>

			<div class="row">
				<div class="col-sm-6">
					<div class="card text-white bg-info mb-3">
						<div class="card-body">
							<h5 class="card-title">View All Employees</h5>
							<p class="card-text">Uses SQL queries using MySql Driver
								manger to get all employees as a list Object</p>
							<a href="viewAll" class="btn btn-dark">View All</a>
						</div>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="card text-white bg-success mb-3">
						<div class="card-body">
							<h5 class="card-title">View Selected Employee</h5>
							<p class="card-text">Uses SQL queries find particular
								employee using ID. Gives subltle alert off errors.</p>
							<a href="selectForm" class="btn btn-dark">Select</a>
						</div>
					</div>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-sm-4">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Register an Employee</h5>
							<p class="card-text">Uses SQL INSERT non-select query to
								register a new employee.</p>
							<a href="register.jsp" class="btn btn-success">Register</a>
						</div>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Update an Employee</h5>
							<p class="card-text">Uses SQL UPDATE non-select query to
								update employee salary.</p>
							<a href="update.jsp" class="btn btn-warning">Update</a>
						</div>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Delete an Employee</h5>
							<p class="card-text">Uses SQL DELETE non-select query to
								delete a new employee using ID.</p>
							<a href="delete.jsp" class="btn btn-danger">Delete</a>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
</div>
<%@ include file="footer.jsp"%>