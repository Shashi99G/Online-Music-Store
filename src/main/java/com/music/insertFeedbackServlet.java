package com.music;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insertFeedbackServlet")
public class insertFeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public insertFeedbackServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			String fullname = request.getParameter("fullname");
	        String email = request.getParameter("email");
	        String subject = request.getParameter("subject");
	        String feedback = request.getParameter("feedback");
	        String ratingParam = request.getParameter("rating");
	        int starRating = -1; 

	        if (ratingParam != null && !ratingParam.isEmpty()) {
	            try {
	            	starRating = Integer.parseInt(request.getParameter("rating"));;
	            } catch (NumberFormatException e) {
	            	e.printStackTrace();
	            }
	        }
	
	        // Establish a database connection 
	        String DB_URL = "jdbc:mysql://localhost:3306/music";
	        String DB_USERNAME = "root";
	        String DB_PASSWORD = "shashi99@";

       
           Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
           
           //Create feedback
           String sql = "INSERT INTO feedbacks (fullname, email, subject, feedback, rating) VALUES (?, ?, ?, ?, ?)";
           
           PreparedStatement preparedStatement = conn.prepareStatement(sql);
           
           preparedStatement.setString(1, fullname);
           preparedStatement.setString(2, email);
           preparedStatement.setString(3, subject);
           preparedStatement.setString(4, feedback);
           preparedStatement.setInt(5, starRating);

           preparedStatement.executeUpdate();

           conn.close();
           
           // Forward the request to the success.jsp page
           RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
           dispatcher.forward(request, response);
           
       } catch (SQLException e) {
           e.printStackTrace();
           response.sendRedirect("unsuccess.jsp");
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
           response.sendRedirect("unsuccess.jsp");
       } catch (IOException e) {
           e.printStackTrace();
           response.sendRedirect("unsuccess.jsp");
       }
       
	}

}
