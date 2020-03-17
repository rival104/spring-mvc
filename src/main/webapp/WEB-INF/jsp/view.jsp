<%@ include file="header.jsp"%>

<div class="container">
	<c:if test="${!isFound}">
		<div class="row justify-content-center">
			<div class="alert alert-warning alert-dismissible fade show"
				role="alert">
				<strong>Query Not Found!</strong> Please check Id in the filed
				below.
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</div>
	</c:if>

	<div class="row justify-content-center">
		<h2>Display Employee Info</h2>
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
				<tr>
					<th scope="row">1</th>
					<td>${emp.getId()}</td>
					<td>${emp.name}</td>
					<td>${emp.sal}</td>
				</tr>

			</tbody>
		</table>
		<a class="btn btn-secondary" href="selectForm" role="button">Go
			Back</a>
	</div>

</div>

<%@ include file="footer.jsp"%>