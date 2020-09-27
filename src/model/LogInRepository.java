package model;

import java.sql.*;


public class LogInRepository {
	
	//attributes
	DataBaseConnection connection ;	
	
	//c'tor
	public LogInRepository()
	{
		this.connection=DataBaseConnection.getConnection();
	}
	
	//methods
	public User userlogIn(String Email, String Pass) throws SQLException  {
		
        connection.conn = DriverManager.getConnection(connection.url);

		
	User old=new User();

	
	try {
		 PreparedStatement st=connection.conn.prepareStatement("select * from USERS where EMAIL=? and PASS=?");
         st.setString(1, Email);
         st.setString(2, Pass);
         
         ResultSet answer = st.executeQuery();
		
         int counter=0;
         while(answer.next())
         	{
        	 counter++;
        	 if(counter==1)
        	{
        		 old.setPass(Pass);
        		 old.setEmail(Email);

        		 String name =answer.getString("NAME");
        		 String phone =answer.getString("PHONE");
        		 old.setName(name);
        		 old.setPhone(phone);
        		 return old;
        	}
        	 
        	}//end while
         
	
        		 old=new User();
        		 return old;
        		 
	}		 
	finally {
		connection.conn.close();
	}
		
	}

	public Admin adminlogIn(String email, String password) throws SQLException {
		
		 Admin old=new Admin();
		
		 try {
		 PreparedStatement st=connection.conn.prepareStatement("select * from ADMIN where EMAIL=? and PASS=?");
		 ResultSet answer=null;
		
			
        st.setString(1, email);
        st.setString(2, password);
        
         answer = st.executeQuery();
		
        int counter=0;
        while(answer.next())
        	{
       	 counter++;
       	 if(counter==1)
       	{
       		 old.setPass(password);
       		 old.setEmail(email);

       	
       		 return old;
       	}
       	 
       
        	}//end while
        
         	old=new Admin("non","non");
       		 return old;
		 }
		 finally {
			 connection.conn.close();
		 }
	}
	
	public Boolean SignUpUser(User newUser) throws SQLException {
		
		if (newUser.getName().equals("non")) {
			return false;
		}
		
				PreparedStatement st=connection.conn.prepareStatement("INSERT INTO USERS (EMAIL,PASS,NAME,PHONE) VALUES (?,?,?,?)");
		        st.setString(1, newUser.getEmail());
		        st.setString(2, newUser.getPassword());
				st.setString(3, newUser.getName());
		        st.setString(4, newUser.getPhone());
		        st.executeUpdate();
			
			return true;
		} 
		
		
        
		
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}// class end
