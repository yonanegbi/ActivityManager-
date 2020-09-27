package controller;



//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import model.Activity;
import model.ActivityFactory;
import model.ActivityRepository;
import model.Admin;
import model.ElementarySchoolActivity;
import model.HighSchoolActivity;
import model.LogInRepository;
import model.OtherActivity;
import model.RatingAndReviewRepository;
import model.ReportRepository;
import model.User;


public class AdminController
{
	
	//attributes
	private RatingAndReviewRepository ratingAndReviewRepository;
	private LogInRepository logInRepository;
	private ActivityRepository activityRepository;
	private ActivityFactory activityFactory;
	private ReportRepository reportRepository;
	
	//c'tor
	public AdminController()
	{
		this.ratingAndReviewRepository=new RatingAndReviewRepository();
		this.activityRepository=new ActivityRepository();
		this.logInRepository=new LogInRepository();
		this.activityFactory=new ActivityFactory();
		this.reportRepository=new ReportRepository();
	}

	//methods
	
	public Admin signIn(Admin admin) {  // gets admin input, if exist-> return the right admin and all his info, else-> return empty admin object
		
		try {
			admin=logInRepository.adminlogIn(admin.getEmail(),admin.getPassword());
		} catch ( SQLException e) {

			e.printStackTrace();
		}
		
		
		return admin;
		
	}

	public Boolean deleteActiviry(int activityID) {
		
		Boolean check=false;
		try {
			check=activityRepository.deleteActivity(activityID);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return check;
		
		
		
	}

	public boolean deleteUserFromActivity(String email, int activityID) {

		try {
			if (activityRepository.IsActivityExsist(activityID)==false) {
				return false;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
		try {
			
			activityRepository.deleteUserFromActivity(email, activityID);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return true;

		
	}
	
	public boolean deleteReview(int SerialNumber ) {

		Boolean check=false;
		try {
			check=ratingAndReviewRepository.IsReviewExist(SerialNumber);
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		if (check==false) {
			return false;
		}
		
		try {
			
			ratingAndReviewRepository.deleteReview(SerialNumber);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return true;
		
	}
	
	public List<User> getAllUser() throws Exception {
		List<User> list = new ArrayList<>();
		
			list=activityRepository.getAllUsers();
			return list;
	
		
		
	}
	
	public Activity getAvtivity(String ActivityType){
	
		   return activityFactory.getAvtivity(ActivityType);
	
		   
	   }
		
	public boolean addElemetarySchoolActivity(ElementarySchoolActivity activity) {

		   try {
			activityRepository.addElamentryShcoolActivity(activity);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	   }   
		   
	public boolean addHighSchoolActivity(HighSchoolActivity activity) {

			   try {
				activityRepository.addHighShcoolActivity(activity);
				return true;
			} catch (Exception e) {

				e.printStackTrace();
				return false;
			}
		   
	}
	      
    public Boolean addOtherActivity(OtherActivity activity) {

			   try {
				activityRepository.addOtherActivity(activity);
				return true;
			} catch (Exception e) {

				e.printStackTrace();
				return false;
			}
		   
	}
		   
	public List<OtherActivity> getActivityByHighRating() throws Exception { // get list of activities, sorted by highest rating first, base on the users review
		List<OtherActivity> list ;
		list=reportRepository.getActivityByHighRating();
		return list;
	}  
	   
    
	public List<User> getUsersInSpecificActivity(int activityId) throws Exception {
		List<User> list = new ArrayList<>();
		list=reportRepository.getUsersInSpecificActivity(activityId);
		return list;
	}  
	   
	
	public Boolean IsActivityExsist(int activityId) throws Exception{
		Boolean bool;
		bool=activityRepository.IsActivityExsist(activityId);
		if (bool) {
			return true;
		} else {
			return false;
		}
	}
    
	
	public Boolean IsReviewExist(int serial) throws Exception
	{
		Boolean bool;
		bool=ratingAndReviewRepository.IsReviewExist(serial);
		if (bool) {
			return true;
		} else {
			return false;
		}
	}// func end



	
	
	}// class end
	
	



	

