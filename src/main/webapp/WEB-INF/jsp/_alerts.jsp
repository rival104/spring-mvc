<c:if test="${isSuccess}">
	<div class="row justify-content-center">
		<div class="alert alert-success alert-dismissible fade show"
			role="alert">
			<strong>Task completed successfully!</strong>${successMsg} }
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
			<strong>Error completing task! </strong>${errorMsg}
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
	</div>
</c:if>