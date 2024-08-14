<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.User.Post" %>
<%@ page import="com.DAO.PostDAO" %>
<%@ page import="com.Db.DBConnect" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Notes</title>
<%@ include file="all_component/allcss.jsp" %>
</head>
<body>
    <%@ include file="all_component/navbar.jsp" %>
    <%
    String updateMsg=(String)session.getAttribute("updateMsg");
    if(updateMsg!=null)
    {%>
    <div class="alert alert-success" role="alert"><%=updateMsg%></div>
    <%
    	session.removeAttribute("updateMsg");
    }
    %>

	<%
	String wrongMsg = (String) session.getAttribute("wrongMsg");
	if (wrongMsg != null) {
	%>
	<div class="alert alert-danger" role="alert"><%=wrongMsg%></div>
	<%
	session.removeAttribute("wrongMsg");
	}
	%>
	
	
	<div class="container">
        <h2 class="text-center">All Notes</h2>
        <%
        UserDetails user3 = (UserDetails) session.getAttribute("userD");

        if (user3 == null) {
            response.sendRedirect("login.jsp");
            session.setAttribute("Login-error", "Please Login...");
        } else {
            PostDAO postDAO = new PostDAO(DBConnect.getCon());
            List<Post> posts = postDAO.getPostsByUserId(user.getId());

            if (posts != null && !posts.isEmpty()) {
                for (Post post : posts) {
        %>
        <div class="card mt-3">
            <img alt="" src="img/shownotes.jpg"
                class="card-img-top mt-2 mx-auto" style="max-width: 150px;">
            <div class="card-body p-4">
                <h5 class="card-title"><%= post.getTitle() %></h5>
                <p><%= post.getContent() %></p>
                <p>
                    <b class="text-success">Published By: <%= user.getName() %></b><br>
                    <b class="text-primary"></b>
                </p>
                <p>
                    <b class="text-success">Published Date: <%= post.getDate() %></b><br>
                    <b class="text-success"></b>
                </p>
                <div class="container text-center mt-2">
                    <a href="deleteServlet?note_id=<%=post.getId() %>" class="btn btn-danger">Delete</a>
                    
                    
                    
                    <a href="edit.jsp?note_id=<%=post.getId() %>"
                    class="btn btn-primary">Edit</a>
                </div>
            </div>
        </div>
        <%
                }
            } else {
                out.print("<h1 class=\"text-center\">No notes available</h1>");
            }
        }
        %>
    </div>
   
</div>
</body>
</html>
