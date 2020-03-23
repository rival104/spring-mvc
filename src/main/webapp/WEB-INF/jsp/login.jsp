<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css">
<title>Spring MVC App</title>
</head>
<body>
	
	<div class="login">
	    <h1>Login</h1>
	    <form action="login" method="post">
	        <input type="text" name="username" placeholder="Username"  required/>
	        <input type="password" name="password" placeholder="Password"  required/>
	        <button type="submit" class="btn btn-primary btn-block btn-large">Let me in.</button>
	    </form>
	</div>

</body>
</html>