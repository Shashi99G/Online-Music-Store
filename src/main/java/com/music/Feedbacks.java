package com.music;

public class Feedbacks {
	private int id;
	private String fullname;
	private String email;
	private String subject;
	private String feedback;
	private int rating;
	private String time;
	
	
	public Feedbacks(int id, String fullname, String email, String subject, String feedback, int rating, String time) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.subject = subject;
		this.feedback = feedback;
		this.rating = rating;
		this.time = time;
	}
	public Feedbacks() {
		super();
	}
	public Feedbacks(int id, String fullname, String email, String subject, String feedback) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.subject = subject;
		this.feedback = feedback;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

}
