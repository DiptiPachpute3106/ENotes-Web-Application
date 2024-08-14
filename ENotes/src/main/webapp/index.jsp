<%@page import="com.Db.DBConnect"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="com.User.UserDetails" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.back-img{
background:url("img/Bookpen.jpg");
width:100%;
height:80vh;
background-repeat:no-repeat;
background-size:cover;
}
</style>
<meta charset="UTF-8">
<title>Home Page</title>
<%@include file="all_component/allcss.jsp" %>
</head>
<body>
<%@include file="all_component/navbar.jsp" %>

<%
	Connection con=DBConnect.getCon();
	System.out.println(con);
%>
<div class="container-fluid back-img">
<div class="text-center">
<h1 class= text-white><i class="fa fa-book" aria-hidden="true"></i>E Notes-Save Your Notes</h1>
<a href="login.jsp" class="btn btn-light"><i class="fa fa-user-circle-o" aria-hidden="true"></i>Login</a>
<a href="register.jsp" class="btn btn-light"><i class="fa fa-user-plus" aria-hidden="true"></i>Register</a>
</div>
</div>
<div class="container-fluid bg-dark mt-0.5">
<p class="text-center text-white">Note: Any errors occur then contact Dipti. Designed & developed by Dipti Pachpute</p>
<p class="text-center text-white">All Right Reserved @diptipachpute-2024-25</p>

</div>
</body>
</html>