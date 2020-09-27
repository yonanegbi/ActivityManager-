package view;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

import model.OtherActivity;
import model.User;

public class ReportMaker {

	
public Boolean createReaportOfAllUsers(List<User> list) { //gets list of users crate report file  

		try {
	     FileWriter fw = new FileWriter("reportReaportOfAllUsers.txt"); 
	     //   @SuppressWarnings("resource")
			BufferedWriter bw = new BufferedWriter(fw);
	        String line = "";
	        String line2 = "Report of all Users :";
	        String line3= "---------------------------";
	        bw.write(line2);
	        bw.newLine();
	        bw.write(line3);
	        bw.newLine();

	        for(int i=0; i<list.size();i++)
	        {
	        	line = list.get(i).toString();
	        	bw.write((i+1)+".\t"+line);
	            bw.newLine();
	        }
	      
	        bw.close(); 
	        return true;
			} catch (Exception e) {
				return false;
		}   
		}

public Boolean createReaportOfMostRating(List<OtherActivity> list) {

		try {
	     FileWriter fw = new FileWriter("reportActivitesByRating.txt"); 
	    //    @SuppressWarnings("resource")
			BufferedWriter bw = new BufferedWriter(fw);
	        String line = "";
	        String line2 = "Report of highest rating :   ";
	        String line3= "---------------------------\n name\t	id\trating";
	        bw.write(line2);
	        bw.newLine();
	        bw.write(line3);
	        bw.newLine();

	        for(int i=0; i<list.size();i++)
	        {
	        	
	        line=(i+1)+". "+list.get(i).getName()+"\t"+list.get(i).getActivityID()+"\t"+list.get(i).getPrice();
	        	bw.write(line);
	            bw.newLine();	        }
	        
	        bw.close();
	        return true;
	        	
			} catch (Exception e) {
				e.printStackTrace();
				return false;
		}   
		}

public Boolean createReaportOfUsersInSpecificActivity(List<User> list, int id) {

	try {
     FileWriter fw = new FileWriter("Report_Specific_Activity.txt"); 
    //    @SuppressWarnings("resource")
		BufferedWriter bw = new BufferedWriter(fw);
        String line = "";
        String line2 = "Report of all users in activity "+id;
        String line3= "---------------------------\n Email \n-------";
        bw.write(line2);
        bw.newLine();
        bw.write(line3);
        bw.newLine();

        for(int i=0; i<list.size();i++)
        {
        	line = list.get(i).getEmail();
        	bw.write((i+1)+".\t"+line);
            bw.newLine();
        }
        bw.close();
        return true;
		} catch (Exception e) {
			return false;
	}   
	}


		

	

	

	
}// class end
