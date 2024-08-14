package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.tomcat.jakartaee.bcel.classfile.ClassFormatException;

import com.DAO.UserDAO;
import com.Db.DBConnect;
import com.User.UserDetails;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ClassFormatException,IOException
	{
		String name=request.getParameter("fname");
		String email=request.getParameter("uemail");
		String password=request.getParameter("upassword");
		
		
		UserDetails us=new UserDetails();
		us.setName(name);
		us.setEmail(email);
		us.setPassword(password);
		
		UserDAO dao=new UserDAO(DBConnect.getCon());
		boolean f=dao.addUser(us);
		HttpSession session;
		
		if(f)
		{
			session=request.getSession();
			session.setAttribute("reg-success", "Registration sucessfully...");
			response.sendRedirect("register.jsp");
			
		}
		else
		{
			session=request.getSession();
			session.setAttribute("failed-msg", "Something went wrong on server");
			response.sendRedirect("register.jsp");
		}
	}
	

}
