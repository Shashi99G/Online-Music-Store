<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Review Form</title>
<link rel="stylesheet" href="CSS/feedbackFormStyle.css">
<link rel="stylesheet" href="CSS/headerStyle.css">
<style>
    body{
        width: 100%;
        height: 100vh;
        background:url(images/im_3.jpg)no-repeat 50% 50%;
        background-size:cover;
        background-attachment: fixed;       
    }
</style>
</head>
<body>
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
    </header>

    <div class="feedback_Form">
        <form id="feedbackForm" action="insertFeedbackServlet" method="post">
            <div class="feedbackForm">
                <h1 class="heading">Write your feedback</h1>
                <div class="inputfields">
                    <label for="" class="label">Name</label><br>
                    <input type="text" name="fullname" id="name">
                    <br>
                    <label for="" class="label">E-mail</label><br>
                    <input type="email" name="email" class="email" id="email">
                    <br>
                    <label for="" class="label">Subject</label><br>
                    <input type="text" name="subject" class="email" id="subject">
                    <br>
                    <label for="" class="label">Feedback</label><br>
                    <textarea id="feedback" name="feedback" rows="4"></textarea>
                    <br>
                    <p class="p2">You can rate our company by stars below.</p>
                    <div class="rating">
                        <input type="hidden" name="rating" id="rating" value="0">
                        <span class="stars">&#9733;</span>
                        <span class="stars">&#9733;</span>
                        <span class="stars">&#9733;</span>
                        <span class="stars">&#9733;</span>
                        <span class="stars">&#9733;</span>
                    </div>
                </div>
                <input type="submit" name="submit" value="Submit" class="Submit" onclick="return validateForm();">
            </div>
        </form>
    </div>

    <script>
    
    
    const stars = document.querySelectorAll(".stars");
    let userRating = 0;

    stars.forEach((star, index) => {
        star.addEventListener("click", () => {
            userRating = index + 1;
            highlightStars(index);
            
            const starRatingInput = document.getElementById("rating");
            starRatingInput.value = userRating;
        });
    });

    function highlightStars(index) {
        stars.forEach((star, i) => {
            if (i <= index) {
                star.style.color = "#FFD700"; 
            } else {
                star.style.color = "#000"; 
            }
        });
    }
    
    
    
    
    //Form validation
        function validateForm() {
            var fullname = document.getElementById("name").value;
            var email = document.getElementById("email").value;
            var subject = document.getElementById("subject").value;
            var feedback = document.getElementById("feedback").value;
            var rating = document.getElementById("rating").value;
    
            var namePattern = /^[A-Za-z]+$/; // Pattern for full name validation
            var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/; // Pattern for email validation
    
            var isValid = true;
    
            if (fullname.trim() === "") {
                alert("Full name is required.");
                isValid = false;
            } else if (!namePattern.test(fullname)) {
                alert("Full name can only contain letters.");
                isValid = false;
            }
    
            if (email.trim() === "") {
                alert("Email is required.");
                isValid = false;
            } else if (!emailPattern.test(email)) {
                alert("Please enter a valid email address.");
                isValid = false;
            }
    
            if (subject.trim() === "") {
                alert("Subject is required.");
                isValid = false;
            }
    
            if (feedback.trim() === "") {
                alert("Feedback is required.");
                isValid = false;
            }
    
            if (rating === "0") {
                alert("Please rate our company by selecting 1 to 5 stars.");
                isValid = false;
            }
    
            return isValid;
        }
    </script>
</body>
</html>
