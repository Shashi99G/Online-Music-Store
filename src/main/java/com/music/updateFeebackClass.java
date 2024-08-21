package com.music;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.music.FeedbacksDao;
import com.music.Feedbacks;

public class updateFeebackClass {
public Feedbacks getValuesOfFeedbacks(String Id) {
		
		
		PreparedStatement ps =null;
		ResultSet rs = null;
		Feedbacks feedback_update = new Feedbacks();
		
		
		try {
			Connection connection = FeedbacksDao.getConnection();
		String sql ="SELECT id, fullname, email, subject, feedback, rating, time FROM feedbacks where id=?";
		ps = connection.prepareStatement(sql);
		ps.setString(1, Id);
		rs =ps.executeQuery();
		
		while(rs.next()) {
	
			feedback_update.setId(rs.getInt("id"));
			feedback_update.setFullname(rs.getString("fullname"));
			feedback_update.setEmail(rs.getString("email"));
			feedback_update.setSubject(rs.getString("subject"));
			feedback_update.setFeedback(rs.getString("feedback"));
			feedback_update.setRating(rs.getInt("rating"));
			feedback_update.setTime(rs.getString("time"));
		
		}
		
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return feedback_update;
	
	}
}
