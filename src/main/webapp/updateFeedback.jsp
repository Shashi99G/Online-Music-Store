<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<%@ page import="com.music.updateFeebackClass" %>
	<%@ page import="com.music.Feedbacks" %>
	
	    <% String fullname=(String) session.getAttribute("fullname");%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Review update</title>
<link rel="stylesheet" href="CSS/updateFeedbackStyle.css">
<link rel="stylesheet" href="CSS/headerStyle.css">
<style>
        body{
            width: 100%;
            height: 100vh;
            background:url(images/im_5.jpg)no-repeat 50% 50%;
            background-size:cover;
            background-attachment: fixed;       
        }

</style>
</head>
<body>


<%
String id = request.getParameter("id");
updateFeebackClass obj_update_value = new updateFeebackClass();
Feedbacks feedback_update = obj_update_value.getValuesOfFeedbacks(id);
%>


<div class="wrapper">
		    <header>
            
	            	  <nav>
	                    <div class="menu">
	                        <ul>
	                            <li><a href="">Home</a></li>
	                            <li><a href="">Services</a></li>
	                            <li><a href="">About Us</a></li>
	                            <li><a href="">Contact Us</a></li>
								<li><a href="<%=request.getContextPath()%>/allFeedbacksServlet">Feedbacks</a></li>
	                        </ul>
	                    </div>                   
	                </nav>
                
             
            <!-- Display user feedbacks -->  
            
            <div class = "updateBox">

				<form action="updateFeedbackServlet" method="post">
					<h1 class="heading">Update Review</h1>
					
				    <input type="hidden" name="id" value="<%= feedback_update.getId() %>"><br>
				    <label for="" class="label">Name :</label><br>
				    <input type="text" name="fullname" class = "updatedName" value="<%= feedback_update.getFullname() %>"><br>
				    <label for="" class="label">Email :</label><br>
				    <input type="email" name="email" class = "updatedEmail" value="<%= feedback_update.getEmail() %>"><br>
				    <label for="" class="label">Subject :</label><br>
				    <input type="text" name="subject" class = "updatedSubject" value="<%= feedback_update.getSubject() %>"><br>
				    <label for="" class="label">Feedback :</label><br>
				    <textarea name="feedback"  class = "updatedFeedback"><%= feedback_update.getFeedback() %></textarea><br>
				    <label for="" class="label">Number of stars :</label><br>
				    <input type="number" name="rating" min="1" max="5"  class = "updatedStar" value="<%= feedback_update.getRating() %>"><br>
				    
				    <input type="submit" name="submit" class = "update" value="Update">
				</form>
			
			</div>
			
			</header>
    
                          
        </div>



</body>
</html>