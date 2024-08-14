<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body>
	<%@include file="all_component/navbar.jsp"%>
	<div class="container-fluid div-color">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card mt-4">
					<div class="card-header text-center text-white bg-custom">
						<i class="fa fa-user-plus fa-3x" aria-hidden="true"></i>
						<h4>Registration</h4>
					</div>

					<%
						String successMsg = (String) session.getAttribute("reg-success");
						if (successMsg != null) {
					%>
					<div class="alert alert-success" role="alert"><%= successMsg %></div>
					<%
							session.removeAttribute("reg-success");
						}
					%>

					<%
						String failedMsg = (String) session.getAttribute("failed-msg");
						if (failedMsg != null) {
					%>
					<div class="alert alert-danger" role="alert"><%= failedMsg %></div>
					<%
							session.removeAttribute("failed-msg");
						}
					%>

					<div class="card-body">
						<form action="UserServlet" method="post">
							<div class="form-group">
								<label>Enter Full Name</label>
								<input type="text" class="form-control" name="fname">
							</div>
							<div class="form-group">
								<label>Enter Email</label>
								<input type="email" class="form-control" name="uemail">
							</div>
							<div class="form-group">
								<label>Enter Password</label>
								<input type="password" class="form-control" name="upassword">
							</div>
							<button type="submit" class="btn btn-primary badge-pill btn-block">Register</button>
						</form>
					</div>

				</div>
			</div>
		</div>
	</div>
<div class="container-fluid bg-dark mt-0.5">
<p class="text-center text-white">Note: Any errors occur then contact Dipti. Designed & developed by Dipti Pachpute</p>
<p class="text-center text-white">All Right Reserved @diptipachpute-2024-25</p>

</div>
</body>
</html>