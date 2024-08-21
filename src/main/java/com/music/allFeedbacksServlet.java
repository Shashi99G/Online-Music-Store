package com.music;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.music.Feedbacks;
import com.music.FeedbacksDao;

@WebServlet("/allFeedbacksServlet")
public class allFeedbacksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public allFeedbacksServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listAllReviews(request, response);	
	}

	private void listAllReviews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Feedbacks> listFeedbacks = FeedbacksDao.selectAllReviews();
			request.setAttribute("listFeedbacks", listFeedbacks);
			RequestDispatcher dispatcher = request.getRequestDispatcher("allFeedbacks.jsp");
			dispatcher.forward(request,  response);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}


}
