<%@page language="java" contentType="text/html; charset=ISO-8859-1" session="true"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</head>
<body
	style="background: url(images/1.jpg); background-size: cover; background-attachment: fixed;">
	<div class="container">
		<div class="row">
			<div class="col m6 offset-m3">
				<div class="card">
					<div class="card-content">
						<h4 style="margin-top: 10px; text-align: center;">Change Password							</h4>
						<div class="form center-align">
							<form action="changePasswordSrv" method="post">
								<input placeholder="Enter Old Password" id="oldPass" type="password"
									class="validate" name="oldPassword"> <input
									placeholder="Enter New Password" id="newPassword" type="password"
									class="validate" name="newPassword">
									<input
									placeholder="Enter New Confirm Password" id="newCnfPassword" type="password"
									class="validate" name="newCnfPassword">
								<button type="submit" class="btn red">Submit</button>
								<a href="forgotPassword.jsp">Forgot Password</a>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>