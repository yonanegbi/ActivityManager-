package view;

import model.User;

public class ContactBox {

	
	//attributes
	String text;
	
	//get+set
	public void setText(String text) {
		this.text = text;
	}
	
	//methods
	public void send(User user)
	{
		System.out.println("Your message sent to city.muni@org.il Please check " +user.getEmail()+ " for reply soon!\n");
	}

	
	
}