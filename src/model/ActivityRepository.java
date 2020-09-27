package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ActivityRepository {

	
//attributes	
DataBaseConnection connection ;	

//c'tor
public ActivityRepository()
	{
		this.connection=DataBaseConnection.getConnection();
	}
	
	
	

	
// methods	
public List<OtherActivity> getOtherActivity() throws Exception {

	List<OtherActivity> list = new ArrayList<>();

	
	
	
    connection.conn = DriverManager.getConnection(connection.url);
    

try {
	
	Statement myStmt = connection.conn.createStatement();
	ResultSet myRs = myStmt.executeQuery("select activityID, name, location,CurrentCap,MaxCap, price,Description,Guide,Category,AgeRange   from Activity where guide IS NOT NULL");

          
	while (myRs.next()) {
		OtherActivity tempEmployee = convertRowToOtherActivity(myRs);
		list.add(tempEmployee);
		
	}   
          
	return list;	  
        
         

	}//end try

finally {
	connection.conn.close();
}

}// func end	

public List<HighSchoolActivity> getHighSchoolActivity() throws Exception {

	List<HighSchoolActivity> list = new ArrayList<>();

	
	
	
    connection.conn = DriverManager.getConnection(connection.url);
    

try {
	
	Statement myStmt = connection.conn.createStatement();
	ResultSet myRs = myStmt.executeQuery("select activityID, name, location,CurrentCap,MaxCap, price,Description,Teacher,Profession,RemoteClass,StudyUnits,FinalExam,SchoolAss   from Activity where StudyUnits IS NOT NULL");

          
	while (myRs.next()) {
		HighSchoolActivity tempEmployee = convertRowToHighSchoolActivity(myRs);
		list.add(tempEmployee);
		
	}   
          
	return list;	  
        
         

	}//end try

finally {
	connection.conn.close();
}

}// func end	

public List<ElementarySchoolActivity> getElementarySchoolActivity() throws Exception {

	List<ElementarySchoolActivity> list = new ArrayList<>();

	
	
	
    connection.conn = DriverManager.getConnection(connection.url);
    

try {
	
	Statement myStmt = connection.conn.createStatement();
	ResultSet myRs = myStmt.executeQuery("select activityID, name, location,CurrentCap,MaxCap, price,Description,Teacher,Profession,RemoteClass,certification,transport,access   from Activity where transport IS NOT NULL");

          
	while (myRs.next()) {
		ElementarySchoolActivity tempEmployee = convertRowToElementarySchoolActivity(myRs);
		list.add(tempEmployee);
		
	}   
          
	return list;	  
        
         

	}//end try

finally {
	connection.conn.close();
}

}// func end	

public OtherActivity convertRowToOtherActivity(ResultSet myRs) throws SQLException {
		
	    int activityID = myRs.getInt("ActivityID");
		  String name= myRs.getString("Name");
		  String location= myRs.getString("Location");
		  int currentCapicity= myRs.getInt("CurrentCap");
		  int maxCapicity= myRs.getInt("MaxCap");
		  double price= myRs.getInt("Price");
		  String description= myRs.getString("Description");
		  String guide= myRs.getString("Guide");
		 String category= myRs.getString("Category");
		 String ageRange= myRs.getString("AgeRange");
		
		OtherActivity temp = new OtherActivity(activityID,name, location, currentCapicity,maxCapicity,price,description,guide,category,ageRange);
		
		return temp;
	}
	
public HighSchoolActivity convertRowToHighSchoolActivity(ResultSet myRs) throws SQLException {
	
    int activityID = myRs.getInt("ActivityID");
	  String name= myRs.getString("Name");
	  String location= myRs.getString("Location");
	  int currentCapicity= myRs.getInt("CurrentCap");
	  int maxCapicity= myRs.getInt("MaxCap");
	  double price= myRs.getInt("Price");
	  String description= myRs.getString("Description");
	  String teacher= myRs.getString("Teacher");
	 String profession= myRs.getString("Profession");
	 String remoteClass= myRs.getString("RemoteClass");
	  int studyUnits= myRs.getInt("StudyUnits");
		 String finalExam= myRs.getString("FinalExam");
		 String schoolAssociation= myRs.getString("SchoolAss");



	
	HighSchoolActivity temp = new HighSchoolActivity(activityID,name, location, currentCapicity,maxCapicity,price,description,teacher,profession,remoteClass,studyUnits,finalExam,schoolAssociation);
	
		 
	return temp;
}

public ElementarySchoolActivity convertRowToElementarySchoolActivity(ResultSet myRs) throws SQLException {
	
    int activityID = myRs.getInt("ActivityID");
	  String name= myRs.getString("Name");
	  String location= myRs.getString("Location");
	  int currentCapicity= myRs.getInt("CurrentCap");
	  int maxCapicity= myRs.getInt("MaxCap");
	  double price= myRs.getInt("Price");
	  String description= myRs.getString("Description");
	  String teacher= myRs.getString("Teacher");
	 String profession= myRs.getString("Profession");
	 String remoteClass= myRs.getString("RemoteClass");
	 String certification= myRs.getString("certification");
	 String transport= myRs.getString("transport");
	 String accessable= myRs.getString("access");

		

	
		 ElementarySchoolActivity temp = new ElementarySchoolActivity(activityID,name, location, currentCapicity,maxCapicity,price,description,teacher,profession,remoteClass,certification,transport,accessable);
	
		 
	return temp;
}

public void RegisterUserToAvctivity(User user,int activityID) throws Exception
{
    connection.conn = DriverManager.getConnection(connection.url);

try {
               
            PreparedStatement st=  connection.conn.prepareStatement("INSERT INTO USERinACTIVITY (USER_EMAIL,ACTIVITY_ID) VALUES (?,?)");
            st.setString(1, user.getEmail());
            st.setInt(2, activityID);
			
            st.executeUpdate();
           
           
		}//end try

	finally {
		  connection.conn.close();
	}


}
	
public  int capicityByActivity(int activityId) throws Exception
{
    connection.conn = DriverManager.getConnection(connection.url);
	
	try {
		
            
            PreparedStatement st=connection.conn.prepareStatement("select maxcap-currentcap from Activity where ActivityID=?");
            st.setInt(1, activityId);
            ResultSet answer = st.executeQuery();
           
            while(answer.next())
            {
            	
            	int cap=answer.getInt(1);
            	

				return cap;		
            
            }
            

		}//end try

	finally {
		connection.conn.close();
	}
	return -1;	
}

public  void incrementCapicity(int activityId) throws Exception
{
    connection.conn = DriverManager.getConnection(connection.url);
	
	try {
		
           
            
            PreparedStatement st=connection.conn.prepareStatement("UPDATE Activity SET currentcap = currentcap + 1 WHERE activityid = ?");
            st.setInt(1, activityId);
           st.execute();
           
            

		}//end try

	finally {
		connection.conn.close();
	}
}

public  void reduceCapicity(int activityId) throws Exception
{
    connection.conn = DriverManager.getConnection(connection.url);
	
	try {
		
            
            PreparedStatement st= connection.conn.prepareStatement("UPDATE Activity SET currentcap = currentcap - 1 WHERE activityid = ?");
            st.setInt(1, activityId);
           st.execute();
           
            

		}//end try

	finally {
		 connection.conn.close();
	}
}
	
public Boolean  deleteActivity(int activityId) throws Exception
{
    connection.conn = DriverManager.getConnection(connection.url);

	try {
						

		 PreparedStatement st3=connection.conn.prepareStatement(" select ActivityID from Activity where (ActivityID = (?))");
		 st3.setInt(1, activityId); 
		 ResultSet myRs1=st3.executeQuery();
		 if (myRs1.next()==false)
		 {
			 return false;
		 }

						       	                         
           // שאילתה שתביא לי את השורה המבוקשת
           PreparedStatement st1=connection.conn.prepareStatement("DELETE FROM Activity WHERE ActivityID LIKE (?)");
           PreparedStatement st2=connection.conn.prepareStatement("DELETE FROM USERinACTIVITY WHERE ACTIVITY_ID LIKE (?)");
	        
	       st1.setInt(1, activityId); 		            
	       st1.executeUpdate();
	       st2.setInt(1, activityId); 
	       st2.executeUpdate();
	      
	           
			}//end try
	finally {
		connection.conn.close();
	}
	
	return true;
}// func end

public int deleteUserFromActivity(String email, int activityId) throws Exception
{
    connection.conn = DriverManager.getConnection(connection.url);
	ResultSet myRs1 = null;
	ResultSet myRs2 = null;
	try {
		
              
		connection.conn.createStatement();  
             PreparedStatement st2=connection.conn.prepareStatement(" select ACTIVITY_ID from USERinACTIVITY where (ACTIVITY_ID = (?)) ");
             st2.setInt(1, activityId);
             myRs2=st2.executeQuery();
             
             
             
             connection.conn.createStatement();  
             PreparedStatement st3=connection.conn.prepareStatement(" select USER_EMAIL from USERinACTIVITY where (USER_EMAIL LIKE (?)) ");
             st3.setString(1, email);
             myRs1=st2.executeQuery();
             
             if ((myRs1.next() || myRs2.next()) == false )
            	 return 0;

             
             
             
             connection.conn.createStatement();  
           // שאילתה שתביא לי את השורה המבוקשת
           PreparedStatement st=connection.conn.prepareStatement("DELETE FROM USERinACTIVITY WHERE USER_EMAIL LIKE (?) and (ACTIVITY_ID = (?))");
            
           st.setString(1,email);	
	       st.setInt(2, activityId);
	       st.executeUpdate();
	      		       
	      
	     			           
			}//end try
	finally {
		connection.conn.close();
		
	}
	return 1;
	 
}// func end

public List<User> getAllUsers() throws Exception {

	List<User> list = new ArrayList<>();

	
	
	
    connection.conn = DriverManager.getConnection(connection.url);
    

try {
	
	Statement myStmt = connection.conn.createStatement();
	ResultSet myRs = myStmt.executeQuery("select *   from USERS ");

          
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
	
    
	 String email= myRs.getString("EMAIL");
	 String name= myRs.getString("NAME");
	 String phone= myRs.getString("PHONE");
	 String pass= myRs.getString("PASS");

		

	
		 User temp = new User(email, pass, name, phone);
	
		 
	return temp;
}

public  void addElamentryShcoolActivity(ElementarySchoolActivity Other) throws Exception {
	
	connection.conn = DriverManager.getConnection(connection.url);	//ResultSet myRs = null;

	try {
		 

	            PreparedStatement st=connection.conn.prepareStatement("INSERT INTO Activity (activityID, name, location, currentCap, maxCap, price, description,teacher, profession,remoteclass, certification, transport, access)"
	            		+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
	            st.setInt(1,  Other.getActivityID());
	            st.setString(2, Other.getName());
	            st.setString(3, Other.getLocation());
	            st.setInt(4, Other.getCurrentCapicity()); 
	            st.setInt(5, Other.getMaxCapicity()); 
	            st.setDouble(6, Other.getPrice());
	            st.setString(7, Other.getDescription()); 
	            st.setString(8, Other.getTeacher()); 
	            st.setString(9, Other.getProfession()); 
	            st.setString(10, Other.getRemoteClass()); 
	            st.setString(11, Other.getCertification());
	            st.setString(12, Other.getTransport());  
	            st.setString(13, Other.getAccessable());
	          
	          	 st.executeUpdate();
			
	          	 
			}//end try

		finally {
			connection.conn.close();
}
	
	}// func end

public  void addHighShcoolActivity(HighSchoolActivity Other) throws Exception {
	
	connection.conn = DriverManager.getConnection(connection.url);	//ResultSet myRs = null;

	try {
		 

	            PreparedStatement st=connection.conn.prepareStatement("INSERT INTO Activity (activityID, name, location, currentCap, maxCap, price, description,teacher, profession,remoteclass, StudyUnits, FinalExam, SchoolAss)"
	            		+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
	            st.setInt(1,  Other.getActivityID());
	            st.setString(2, Other.getName());
	            st.setString(3, Other.getLocation());
	            st.setInt(4, Other.getCurrentCapicity()); 
	            st.setInt(5, Other.getMaxCapicity()); 
	            st.setDouble(6, Other.getPrice());
	            st.setString(7, Other.getDescription()); 
	            st.setString(8, Other.getTeacher()); 
	            st.setString(9, Other.getProfession()); 
	            st.setString(10, Other.getRemoteClass()); 
	            st.setInt(11, Other.getStudyUnits());
	            st.setString(12, Other.getFinalExam());  
	            st.setString(13, Other.getSchoolAssociation());
	          
	          	 st.executeUpdate();
			
	          	 
			}//end try

		finally {
			connection.conn.close();
}
	
	}// func end

public  void addOtherActivity(OtherActivity Other) throws Exception {
	
	connection.conn = DriverManager.getConnection(connection.url);	//ResultSet myRs = null;

	try {
		 

	            PreparedStatement st=connection.conn.prepareStatement("INSERT INTO Activity (activityID, name, location, currentCap, maxCap, price, description,Guide, Category,AgeRange)"
	            		+ " VALUES (?,?,?,?,?,?,?,?,?,?)");
	            st.setInt(1,  Other.getActivityID());
	            st.setString(2, Other.getName());
	            st.setString(3, Other.getLocation());
	            st.setInt(4, Other.getCurrentCapicity()); 
	            st.setInt(5, Other.getMaxCapicity()); 
	            st.setDouble(6, Other.getPrice());
	            st.setString(7, Other.getDescription()); 
	            st.setString(8, Other.getGuide()); 
	            st.setString(9, Other.getCategory()); 
	            st.setString(10, Other.getAgeRange()); 
	     
	          	 st.executeUpdate();
			
	          	 
			}//end try

		finally {
			connection.conn.close();
}
	
	}// func end
	

public Boolean IsActivityExsist(int activityId) throws Exception
{
    connection.conn = DriverManager.getConnection(connection.url);

	try {
						

		 PreparedStatement st3=connection.conn.prepareStatement(" select ActivityID from Activity where (ActivityID = (?))");
		 st3.setInt(1, activityId); 
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





	
}
