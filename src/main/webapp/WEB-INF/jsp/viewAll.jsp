<%@ include file="header.jsp"%>

<div class="container">
	<%@ include file="_alerts.jsp"%>
	<div class="row justify-content-center">

		<div class="card border-primary mb-3" style="width: 60rem;">
			<div class="card-body">
				<h5 class="card-header text-center py-4">
					Display All <span class="badge badge-secondary">Employee</span>
				</h5>
			</div>
		</div>
		<div class="table-responsive">
			<table class="table table-bordered table-hover">
				<thead>
					<tr class="bg-blue">
						<th scope="col">#</th>
						<th scope="col">Name</th>
						<th scope="col">Salary</th>
						<th scope="col">Type</th>
						<th scope="col">Designation</th>
						<th scope="col">DOB</th>
						<th scope="col">Contact.</th>
						<th scope="col">Email</th>
						<th scope="col">User Role</th>
						<th scope="col">TechStack</th>
						<th scope="col">Edit</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${empList}" var="emp" varStatus="loop">
						<tr class="bg-second">
							<th scope="row">${loop.index + 1}</th>
							<td><span class="text-capitalize">${emp.name}</span></td>
							<td>${emp.sal}</td>
							<td><span class="text-capitalize">${emp.empType}</span></td>
							<td><span class="text-capitalize">${emp.designation}</span></td>
							<td>${emp.dob}</td>
							<td>${emp.phone}</td>
							<td>${emp.email}</td>
							<td><span class="text-capitalize">${emp.role}</span></td>
							<td><span class="text-capitalize">${emp.techStack}</span></td>
							<td><button type="button" class="btn btn-warning"
									data-toggle="modal" data-target="#editModal"
									data-eid="${emp.getId()}">
									<i class="fas fa-pencil-alt"></i>
								</button>
								<button type="button" class="btn btn-danger" data-toggle="modal"
									data-target="#deleteModal" data-eid="${emp.getId()}">
									<i class="far fa-trash-alt"></i>
								</button></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<a class="btn btn-secondary" href="home" role="button">Go Back</a>
		<!-- Edit Modal -->
		<div class="modal fade" id="editModal" tabindex="-1" role="dialog"
			aria-labelledby="editModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="editModalLabel">Edit Employee</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<!-- Form -->
						<form class="text-center" style="color: #757575;"
							action="updateModal" autocomplete="off" method="post">
							<!-- ID -->
							<div class="md-form">
								<input type="number" class="form-control" id="employeeId"
									name="id" placeholder="Enter ID here" required disabled>
								<label for="employeeId">Employee ID</label>
							</div>
							<!-- Salary -->
							<div class="md-form">
								<input type="number" class="form-control" id="employeeSal"
									name="sal" placeholder="Enter new Salary here" required>
								<label for="employeeSal">Salary</label>
							</div>
							<!-- button -->
							<button
								class="btn btn-outline-warning btn-rounded btn-block my-4 waves-effect z-depth-0"
								type="submit">Update</button>
						</form>
						<!-- Form -->
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>

		<!-- Delete Modal -->
		<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog"
			aria-labelledby="deleteModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="deleteModalLabel">Delete Employee</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<!-- Form -->
						<form class="text-center" style="color: #757575;"
							action="deleteModal" autocomplete="off" method="post">
							<!-- ID -->
							<div class="md-form">
								<input type="number" class="form-control" id="eIdFordel"
									name="id" placeholder="Enter ID here" required disabled>
								<label for="employeeId">Employee ID</label>
							</div>

							<!-- button -->
							<button
								class="btn btn-outline-danger btn-rounded btn-block my-4 waves-effect z-depth-0"
								type="submit">Delete</button>
						</form>
						<!-- Form -->
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>

	</div>

</div>

<%@ include file="footer.jsp"%>