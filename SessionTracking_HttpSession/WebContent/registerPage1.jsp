<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
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
						<h4 style="margin-top: 10px; text-align: center;">Registration Page
						</h4>
						<div class="form center-align">
							<form action="processRegistration1" method="post">
							<input placeholder="Enter Name" id="name"
									type="text" class=" validate" name="name">
								<input placeholder="Enter Email" id="email"
									type="email" class=" validate" name="email">
									<input placeholder="Enter Address" id="address"
									type="text" class=" validate" name="address"> <input
									placeholder="Enter Password" id="password" type="password"
									class="validate" name="password">
									<input placeholder="Enter Age" id="age"
									type="text" class=" validate" name="age">
								<button type="submit" class="btn red">Next</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>