<%@page import="com.Db.DBConnect"%>
<%@ page import="com.DAO.PostDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.User.Post" %>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
UserDetails user1 = (UserDetails) session.getAttribute("userD");

if (user1 == null) {
	response.sendRedirect("login.jsp");
	session.setAttribute("Login-error", "Please Login...");
	return;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Notes</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body>

	<%
	Integer noteid = Integer.parseInt(request.getParameter("note_id"));
	
	PostDAO postdao=new PostDAO(DBConnect.getCon());
	Post post = postdao.getDataById(noteid); 
	
	%>

	<div class="container-fluid">
		<%@include file="all_component/navbar.jsp"%>

		<h1 class="text-center mt-3">Edit Your Notes</h1>

		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<form action="NoteEditServlet" method="post">
					
					<input type="hidden" value="<%=noteid %>" name="noteid">
					
					
					
					
						<div class="form-group">
		
							<label for="exampleInputEmail1">Enter Title</label> <input
								type="text" class="form-control" id="exampleInputEmail1"
								aria-describedby="emailHelp" name="title" required="required" value="<%=post.getTitle() %>">
						</div>

						<div class="form-group">
							<label for="exampleInputEmail1">Enter Content</label>
							<textarea rows="9" cols="" class="form-control" name="content"
								required="required"> <%=post.getContent() %></textarea>
						</div>

						<div class="container text-center">
							<button type="submit" class="btn btn-primary">Add Notes</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="container-fluid bg-dark mt-5">
<p class="text-center text-white">Note: Any errors occur then contact Dipti. Designed & developed by Dipti Pachpute</p>
<p class="text-center text-white">All Right Reserved @diptipachpute-2024-25</p>

</div>
</body>
</html>