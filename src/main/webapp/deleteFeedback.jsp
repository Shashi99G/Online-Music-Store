<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirm deletion</title>
    <link rel="stylesheet" href="CSS/deleteFeedbackStyle.css">
    <style>
        body{
            width: 100%;
            height: 100vh;
            background:url(images/im_2.jpg)no-repeat 50% 50%;
            background-size:cover;
            background-attachment: fixed;                      
        }
	</style>
</head>
<body>
                
             

		<div class="container">
	    <div class="deletebox">
		    <p class="heading">Confirm Deletion</p>
		    <form action="deleteFeedbackServlet" method="post">
		        <input type="hidden" name="id" value="${param.id}">
		        <button type="submit" name="confirmDeletion" value="true" class="true">Delete My Feedback</button>
		        <a href="deleteFeedbackServlet?id=${param.id}&confirmDeletion=false" class="false">Cancel</a>
		    </form>   
        </div>
        </div>
    

</body>
</html>