package model;

public abstract class Account{
	
	
	
	// attributes
	protected String email;
	protected String password;
	

	
	
	
	// getters + setters
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPass(String pass) {
		password = pass;
	}
	
	
	
	// C'tor
	
	public Account(String email,String password) {
		this.email = email;
		this.password = password;
		
	}
	





}
