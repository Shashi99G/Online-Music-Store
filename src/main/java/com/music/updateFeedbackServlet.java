package com.music;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.music.FeedbacksDao;
import com.music.Feedbacks;

@WebServlet("/updateFeedbackServlet")
public class updateFeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public updateFeedbackServlet() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int newId = Integer.parseInt(request.getParameter("id"));
            String newfullname = request.getParameter("fullname");
            String newemail = request.getParameter("email");
            String newsubject = request.getParameter("subject");
            String newfeedback = request.getParameter("feedback");
            int newrating = Integer.parseInt(request.getParameter("rating"));

            // Get the current time
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String newtime = sdf.format(new Date());

            Connection connection = FeedbacksDao.getConnection();
            
            //Update feedback
            String query = "UPDATE feedbacks SET fullname = ?, email = ?, subject = ?, feedback = ?, rating = ?, time = ? WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, newfullname);
            preparedStatement.setString(2, newemail);
            preparedStatement.setString(3, newsubject);
            preparedStatement.setString(4, newfeedback);
            preparedStatement.setInt(5, newrating);
            preparedStatement.setString(6, newtime);
            preparedStatement.setInt(7, newId);

            int rowsUpdated = preparedStatement.executeUpdate();

            connection.close();

            if (rowsUpdated > 0) {
                // Retrieve all reviews, including the updated one
                List<Feedbacks> listFeedbacks = FeedbacksDao.selectAllReviews();
                request.setAttribute("listFeedbacks",listFeedbacks);
                request.getRequestDispatcher("allFeedbacks.jsp").forward(request, response);
            } else {
                response.sendRedirect("unsuccess.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("unsuccess.jsp?message=SQL_Error");
        } catch (IOException e) {
            e.printStackTrace();
            response.sendRedirect("unsuccess.jsp?message=IO_Error");
        }
    }

}
