package com.music;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.music.Feedbacks;

public class FeedbacksDao {
	private static String DB_URL = "jdbc:mysql://localhost:3306/music";
    private static String DB_User = "root";
    private static String DB_Password = "shashi99@";
    private static String JDBC_Driver = "com.mysql.jdbc.Driver";
    
    //Read feedback details
    private static final String Query = "SELECT * FROM feedbacks";
    private static final String select_id_query = "SELECT id, fullname, email, subject, feedback, rating FROM feedbacks WHERE id = ?";
    
    public FeedbacksDao(){
    	
    }


	protected static Connection getConnection() {
    	Connection conn = null;
    	
    	try {
    		Class.forName(JDBC_Driver);
    		conn = DriverManager.getConnection(DB_URL, DB_User, DB_Password);
    	} catch(SQLException e){
    		e.printStackTrace();
    	} catch(ClassNotFoundException e){
    		e.printStackTrace();
    	}
    	return conn;
    }
	
	
    
    
    
    public static Feedbacks selectFeedback(int id) {
    	Feedbacks existingFeedback = null;

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(select_id_query);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String fullname = rs.getString("fullname");
                String email = rs.getString("email");
                String subject = rs.getString("subject");
                String feedback = rs.getString("feedback");
                existingFeedback = new Feedbacks(id, fullname, email, subject, feedback);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return existingFeedback;
    }
    
    
    
    
    public static List<Feedbacks> selectAllReviews(){
    	
    	List <Feedbacks> feedbacks = new ArrayList<>();
    	
    	
    	try (Connection conn = getConnection();
   	        PreparedStatement statement = conn.prepareStatement(Query);){
   			System.out.println(statement);
   			ResultSet result = statement.executeQuery();
   			
   			while(result.next()){
   				int id = result.getInt("id");
   				String fullname = result.getString("fullname");
   				String email = result.getString("email");
   				String subject = result.getString("subject");
   				String feedback = result.getString("feedback");
   				int rating = result.getInt("rating");
   				String time = result.getString("time");
   				feedbacks.add(new Feedbacks(id, fullname, email, subject, feedback, rating, time));
   			}

   			
       } catch(SQLException e){
   		e.printStackTrace();
       }
    	return feedbacks;
    }
    
 
    //Delete feedback
    public boolean deleteFeedback(int id) throws SQLException {
    	boolean rowDeleted;
    	String query = "DELETE FROM feedbacks WHERE id = ?";
    	try (Connection connection = getConnection();
    			PreparedStatement statement = connection.prepareStatement(query);) {
    		statement.setInt(1, id);
    		rowDeleted = statement.executeUpdate() > 0;
    	}
    	return rowDeleted;
    }
}
