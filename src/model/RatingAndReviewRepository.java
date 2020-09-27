package model;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RatingAndReviewRepository {
	
	
	//attributes
	DataBaseConnection connection ;	

	//c'tor
	public RatingAndReviewRepository()
	{
		this.connection=DataBaseConnection.getConnection();

	}

	
	//methods
	public int insertRatingAndReview(RatingAndReview input) throws Exception

	{
        connection.conn = DriverManager.getConnection(connection.url);
	
	Random r = new Random();
	int low = 1;
	int high = 9999;
	int SerialNumber = r.nextInt(high-low) + low;
	try {
		
	          
	            PreparedStatement st=connection.conn.prepareStatement("INSERT INTO RATING (ActivityID,review,rating,SerialNumber) VALUES (?,?,?,?)");
	            st.setInt(1, input.getActivityID());
	            st.setString(2, input.getReview());
	            st.setDouble(3, input.getRating());
	            st.setInt(4, SerialNumber);

	            st.executeUpdate();
	           
	           return SerialNumber;
			}//end try

		
	
		finally {
			connection.conn.close();
		}
	
	
	
	
	
	}
	
	public List<RatingAndReview> getRatingAndReview(int activityID) throws Exception {

		List<RatingAndReview> list = new ArrayList<>();
		
	    connection.conn = DriverManager.getConnection(connection.url);
	    

	try {
		
		PreparedStatement st=connection.conn.prepareStatement("select review,rating,ActivityID,SerialNumber from RATING Where activityID=?");
        st.setInt(1, activityID);
         ResultSet answer = st.executeQuery();
	          
		while (answer.next()) {
			RatingAndReview temp = convertRowToRatingAndReview(answer);
			list.add(temp);
			
		}   
	          
		return list;	  
	        
	         

		}//end try

	finally {
		connection.conn.close();
	}

	}// func end	

	public RatingAndReview convertRowToRatingAndReview(ResultSet myRs) throws SQLException {
		
	    int activityID = myRs.getInt("ActivityID");
	    String review = myRs.getString("review");
	    Double rating = myRs.getDouble("rating");
	    int serial = myRs.getInt("SerialNumber");

		
		 RatingAndReview temp = new RatingAndReview(activityID, review, rating,serial);
		
		return temp;
	}
	
	public  int deleteReview(int SerialNumber) throws Exception
{
    connection.conn = DriverManager.getConnection(connection.url);

	try {
		
             PreparedStatement st2 = connection.conn.prepareStatement("select SerialNumber from RATING where (SerialNumber = (?))");
             st2.setInt(1,SerialNumber); 	
             ResultSet myRs1=st2.executeQuery();
             if (myRs1.next()==false)
			 {
				 return 0;
			 }
   	                         
           // שאילתה שתביא לי את השורה המבוקשת
           PreparedStatement st1=connection.conn.prepareStatement("DELETE FROM RATING  WHERE SerialNumber LIKE (?)");
            
	        // פקודה למחיקת השורה שהתקבלה מהשאילתה
	       st1.setInt(1, SerialNumber); 		            
	       st1.executeUpdate();
	      
	       
	           
			}//end try
	finally
	{
		connection.conn.close();
	}
 return 1;
}// func end


	public Boolean IsReviewExist(int serial) throws Exception
	{
	    connection.conn = DriverManager.getConnection(connection.url);

		try {
							

			 PreparedStatement st3=connection.conn.prepareStatement(" select * from rating where (SerialNumber = (?))");
			 st3.setInt(1, serial); 
			 ResultSet myRs1=st3.executeQuery();
			 if (myRs1.next()==false)
			 {
				 return false;
			 }else {
				 return true;
			 }

			
		           
				}//end try
		finally {
			connection.conn.close();
		}
		
	}// func end

	
	
	
	
}//class end
