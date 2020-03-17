<%@ include file="header.jsp"%>

<div class="container">
	<div class="row justify-content-center">

		<div class="card border-primary mb-3" style="width: 60rem;">
			<div class="card-body">
				<h5 class="card-header text-center py-4">
					<strong>Display All Employee</strong>
				</h5>
			</div>
		</div>
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">#</th>
					<th scope="col">ID</th>
					<th scope="col">Name</th>
					<th scope="col">Salary</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${empList}" var="emp" varStatus="loop">
					<tr>
						<th scope="row">${loop.index + 1}</th>
						<td>${emp.getId()}</td>
						<td>${emp.name}</td>
						<td>${emp.sal}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a class="btn btn-secondary" href="home" role="button">Go
			Back</a>

	</div>

</div>

<%@ include file="footer.jsp"%>