package com.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.DAO.PostDAO;
import com.Db.DBConnect;

@WebServlet("/deleteServlet1")
public class deleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer noteid=Integer.parseInt(request.getParameter("note_id"));
		PostDAO dao=new PostDAO(DBConnect.getCon());
		
		boolean f=dao.DeleteNotes(noteid);
		HttpSession session=null;
		if(f)
		{
			session=request.getSession();
			session.setAttribute("updateMsg", "Notes Delete Successfully");
			response.sendRedirect("showNotes.jsp");
		}
		else
		{
			
			session=request.getSession();
			session.setAttribute("WrongMsg", "Something Went Wrong On Server");
			response.sendRedirect("showNotes.jsp");
		}
		
	}

}
