package model;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReportRepository {
	
	//attributes
	DataBaseConnection connection ;	

	//c'tor
	public ReportRepository()
		{
			this.connection=DataBaseConnection.getConnection();
		}
		
	
	
	//methods


	public List<OtherActivity> getActivityByHighRating() throws Exception {

		List<OtherActivity> list = new ArrayList<>();

	    connection.conn = DriverManager.getConnection(connection.url);
	    

	try {
		
		Statement myStmt = connection.conn.createStatement();
		ResultSet myRs = myStmt.executeQuery("select name, ActivityID, avg(DISTINCT rating) as AverageRating from RATING join Activity using(ActivityID) group by ActivityID order by AverageRating desc ");

	          
		while (myRs.next()) {
			OtherActivity temp = HighRatingRowConverter(myRs);
			list.add(temp);
			
		}   
	          
		return list;	  
	        
	         

		}//end try

	finally {
		connection.conn.close();
	}

	}// func end	

	public OtherActivity HighRatingRowConverter(ResultSet myRs) throws SQLException {
		
	    
	
		 String name= myRs.getString("name");
		 int id= myRs.getInt("ActivityID");
		 double rating= myRs.getDouble("averagerating");

			

		
		 OtherActivity temp = new OtherActivity(id, name, rating);
		
			 
		return temp;
	}

	public List<User> getUsersInSpecificActivity(int activityId) throws Exception {
		List<User> list = new ArrayList<>();

		ResultSet myRs=null;
	    connection.conn = DriverManager.getConnection(connection.url);
	    

	try {
		
		PreparedStatement st1=connection.conn.prepareStatement("select USER_EMAIL from USERinACTIVITY where (ACTIVITY_ID = (?))");
		st1.setInt(1,activityId); 
		myRs= st1.executeQuery();
	          
		while (myRs.next()) {
			User tempEmployee = convertRowToUser(myRs);
			list.add(tempEmployee);
			
		}   
	          
		return list;	  
	        
	         

		}//end try

	finally {
		connection.conn.close();
	}

	}// func end	

	public User convertRowToUser(ResultSet myRs) throws SQLException {
		
	    
		 String email= myRs.getString("USER_EMAIL");
	

			

		
			 User temp = new User(email, "non","non","non");
		
			 
		return temp;
	}
	
	
	


	
	
	
}
