package com.myapp.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class SubmitForm extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            String name = request.getParameter("name");

            
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourDatabase", "ObiDavid", "Dajonemma148627#");

            
            PreparedStatement ps = con.prepareStatement("INSERT INTO tablename (name) VALUES (?)");
            ps.setString(1, name);
            ps.executeUpdate();

            out.println("<html><body>");
            out.println("<h1>Successfully submitted: " + name + "</h1>");
            out.println("</body></html>");
        } catch (Exception e) {
            out.println("<html><body>");
            out.println("<h1>Error during database operation: " + e.getMessage() + "</h1>");
            out.println("</body></html>");
        } finally {
            out.close();
         
        }
    }
}
