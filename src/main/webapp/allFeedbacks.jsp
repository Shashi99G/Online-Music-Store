 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
     
    <%@page import="java.sql.*"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <%@ page import="java.util.List" %>
	<%@ page import="com.music.Feedbacks" %>
	<%@ page import="com.music.FeedbacksDao" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display All Feedbacks</title>
<link rel="stylesheet" href="CSS/allFeedbacksStyle.css">
    
    <style>
        body{
            width: 100%;
            height: 100vh;
            background:url(images/im_1.jpg)no-repeat 50% 50%;
            background-size:cover;
            background-attachment: fixed;                      
        }
	</style>

</head>
<body>

        
                <br><br><br><p class="text">Give us your feedbacks below<br>
                <a href="feedbackForm.jsp" class="write">Write a feedback</a></p><br>
                
			    <div class="feedbacks_box">
							<c:forEach var="feedbacks" items="${listFeedbacks}">
								<div class="tiles">
									<div class="name">~<c:out value="${feedbacks.fullname}"/>~</div>
									<span class="date"><c:out value="${feedbacks.time}"/></span><br><br>
									<div class="star"><c:out value="${feedbacks.rating} stars"/><br>
									<span class="subject">Feedback about </span><c:out value="${feedbacks.subject}"/><br>
									<c:out value="${feedbacks.feedback}"/></div><br>
													
									<a href="updateFeedback.jsp?id=<c:out value='${feedbacks.id}' />" class="update">Update</a>
						            <a href="deleteFeedback.jsp?id=<c:out value='${feedbacks.id}' />" class="delete">Delete</a>
						        </div>
						   </c:forEach>
				</div>	
			
	
</body>
</html>