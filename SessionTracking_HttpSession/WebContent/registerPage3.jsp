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
						<h4 style="margin-top: 10px; text-align: center;">Registration
							Page</h4>
						<div class="form center-align">
							<form action="processRegistration3" method="post">
								<select name="city">
								    <option value='' selected="disabled">Chose your prefered city</option>
									<option value='NOIDA'>NOIDA</option>
									<option value='NEW DELHI'>NEW DELHI</option>
									<option value='HYDERABAD'>HYDERABAD</option>
									<option value='BANGALORE'>BANGALORE</option>
								</select>
								<input placeholder="Enter SALARY" id="sal" type="text"
									class=" validate" name="sal">
								<button type="submit" class="btn red">Submit</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

<script type="text/javascript">
    document.addEventListener('DOMContentLoaded', function() {
	var elems = document.querySelectorAll('select');
	var instances = M.FormSelect.init(elems);
    });
</script>
</html>