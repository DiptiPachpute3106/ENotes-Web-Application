package com.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.DAO.PostDAO;
import com.Db.DBConnect;
import com.User.Post;

@WebServlet("/AddNotesServlet1")

public class AddNotesServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int uid = Integer.parseInt(request.getParameter("uid"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        PostDAO dao = new PostDAO(DBConnect.getCon());
        boolean isAdded = dao.addPost(title, content, uid);  // Updated method name

        if (isAdded) {
            System.out.println("Data inserted successfully");
            response.sendRedirect("showNotes.jsp");
        } else {
            System.out.println("Data not inserted");
        }
    }
}
