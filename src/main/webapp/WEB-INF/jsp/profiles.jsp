<%@ include file="header.jsp"%>
<form action="getProfileByName" id="viewProfile">
	<input type="hidden" name="ename" id="empNameForProfile">
</form>
<div class="container">

	<div class="row justify-content-center">

		<h2>Display Employee Info</h2>
		<div class="ml-auto p-0">
			<select onchange="getSelectedOption()" id="selectEmp">
				<option selected disabled>Show Employee</option>
				<c:forEach items="${names}" var="name">
					<option value="${name}">${name}</option>
				</c:forEach>
			</select>
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