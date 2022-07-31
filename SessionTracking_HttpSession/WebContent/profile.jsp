<%@page import="servlet.Employee"%>
<%@page import="java.util.List,java.util.regex.Pattern"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile Page</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
</head>
<body>
<%!
String  name= null;
static String trimName =  null;
String trimName1 =  null;
 static String userName =  null;
%>
<%
	Employee employee = (Employee) request.getAttribute("empRec");
                        name=  employee.getName();
                    	String[] nameparts = name.split(" ");
                    	String firstlastNam = nameparts[0].charAt(0)+""+nameparts[1].charAt(0);
                    	System.out.println(firstlastNam);
%>



	<nav class="navbar navbar-expand-lg navbar-light bg-light ">
		<a class="navbar-brand" href="#">Navbar</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="home.html">Home</a>
				</li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <%=firstlastNam.toUpperCase()%> </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="ProfileServlet">Profile </a> <a
							class="dropdown-item" href="changePassword.jsp">Change
							Password</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="logoutServlet">Logout </a>
					</div></li>
				<h5 style="margin: 5px;">Login as</h5><div style="color: red; margin: 5px;"> <%=employee.getEmail()%></div>
				<!-- <li class="nav-item"><a class="nav-link disabled" href="#">Disabled</a>
				</li> -->
			</ul>
			<form action="https://www.google.com/search?q=" class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search" name="n1"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</nav>
	<%-- <%
	Employee employee = (Employee) request.getAttribute("empRec");
	%>
 --%>
<div class="container">
  <div class="row">
     <div class=""></div>
   </div>
</div>
	<div class="table-responsive shadow p-3 mbs-5 bg-light rounded">
		<table class="table table-striped table-sm ">
			<thead>
				<tr>
					<th>Id</th>
					<td><small><%=employee.getId()%></small></td>
				</tr>
				<tr>
					<th>Name</th>
					<td><small><%=employee.getName()%></small></td>
				</tr>
				<tr>
					<th>Age</th>
					<td><small><%=employee.getAge()%></small></td>
				</tr>
				<tr>
					<th>Email</th>
					<td><small><%=employee.getEmail()%></small></td>
				</tr>
				<tr>
					<th>Experience</th>
					<td><small><%=employee.getExperience()%></small></td>
				</tr>
				<tr>
					<th>Skill</th>
					<td><small><%=employee.getSkill()%></small></td>
				</tr>
				<tr>
					<th>City</th>
					<td><small><%=employee.getCity()%></small></td>
				</tr>
				<tr>
					<th>Salary</th>
					<td><small><%=employee.getSalary()%></small></td>
				</tr>
				<tr>
					<th>Address</th>
					<td><small><%=employee.getAddress()%></small></td>
				</tr>
			</thead>
			<%-- <tr>
				<td><small><%=employee.getId()%></small></td>
				<td><small><%=employee.getName()%></small></td>
				<td><small><%=employee.getAge()%></small></td>
				<td><small><%=employee.getEmail()%></small></td>
				<td><small><%=employee.getExperience()%></small></td>
				<td><small><%=employee.getSkill()%></small></td>
				<td><small><%=employee.getCity()%></small></td>
				<td><small><%=employee.getSalary()%></small></td>
				<td><small><%=employee.getAddress()%></small></td>
			</tr> --%>
		</table>
	</div>

</body>
</html>