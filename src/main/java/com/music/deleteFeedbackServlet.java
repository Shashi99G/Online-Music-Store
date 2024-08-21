package com.music;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.music.FeedbacksDao;
import com.music.Feedbacks;

@WebServlet("/deleteFeedbackServlet")
public class deleteFeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public deleteFeedbackServlet() {
        super();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request,  response);
       
	}

   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Check if "confirmDeletion" parameter is true
        String confirmDeletion = request.getParameter("confirmDeletion");
        if (confirmDeletion != null && confirmDeletion.equals("true")) {
            // If confirmed, proceed with review deletion
            try {
                int id = Integer.parseInt(request.getParameter("id"));

                FeedbacksDao feedbacks = new FeedbacksDao();
                boolean deleted = feedbacks.deleteFeedback(id);

                if (deleted) {
                    // Feedback successfully deleted
                    List<Feedbacks> listFeedbacks = FeedbacksDao.selectAllReviews();
                    request.setAttribute("listFeedbacks", listFeedbacks);
                    // Forward to allFeedbacks.jsp
                    RequestDispatcher dispatcher = request.getRequestDispatcher("allFeedbacks.jsp");
                    dispatcher.forward(request, response);
                } else {
                    // Feedback deletion failed
                    response.sendRedirect("unsuccess.jsp?deleteSuccess=false");
                }
            } catch (NumberFormatException e) {
                // Handle invalid ID
                response.sendRedirect("unsuccess.jsp?deleteSuccess=false");
            } catch (SQLException e) {
                // Handle SQL error
                response.sendRedirect("unsuccess.jsp?deleteSuccess=false");
            }
        } else {
            // If "confirmDeletion" is not true, cancel the deletion
            response.sendRedirect("allFeedbacks.jsp?deleteSuccess=cancel");
        }
    }
    

}
