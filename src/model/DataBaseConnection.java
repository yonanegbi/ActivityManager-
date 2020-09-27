package model;

import java.sql.*;


//singleton class
public class DataBaseConnection {
	
	// attributes 
    private static DataBaseConnection dataBaseConnection ; // static beacuse of singleton pattern
    Connection conn = null;
	String url;	

	
	
	// private c'tor
	 private DataBaseConnection() {
	        try {
	           this.url = "jdbc:sqlite:c:\\sqlite3\\db\\myDB.db";
	            conn = DriverManager.getConnection(url);
	            
	            System.out.println("Connection to SQLite has been established.");
	            
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	       
	        
	
	  }
	  
	 
	// methods
	 public static DataBaseConnection getConnection()  //return the only object, if created
    { 
        if (dataBaseConnection == null) 
        	dataBaseConnection = new DataBaseConnection(); 
  
        return dataBaseConnection; 
    }
	 
	 
	 
	 
	 
	 

	  
}//class end



