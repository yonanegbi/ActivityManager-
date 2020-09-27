package Testing;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


import controller.AdminController;
import controller.UserController;
//import controller.UserController;
//import model.ActivityRepository;
//import model.Admin;
import model.ElementarySchoolActivity;
import model.HighSchoolActivity;
import model.OtherActivity;
import model.RatingAndReview;
import model.User;
import view.ReportMaker;



public class AdminTest {

	//attributes
	
	AdminController admincontroller=new AdminController();
	OtherActivity other=new OtherActivity();
	HighSchoolActivity high=new HighSchoolActivity();
	ElementarySchoolActivity elementaty=new ElementarySchoolActivity();
	ReportMaker reportMaker=new ReportMaker();
	User user=new User();
	UserController userController=new UserController();

	
	
	@Test
	public void IsReviewExistTest() throws Exception { 
	
	Boolean checker;	
	checker=admincontroller.IsReviewExist(6);
	Assert.assertTrue(checker==true);
	

	checker=admincontroller.IsActivityExsist(5555555);
	Assert.assertTrue(checker==false);
	
	
	}
	
	@Test
	public void report_allUsers_Test() throws Exception { 
		List<User> list = new ArrayList<>();
		list=admincontroller.getAllUser();
	Boolean checker;	
	checker=reportMaker.createReaportOfAllUsers(list);
	Assert.assertTrue(checker==true);
	

	File f = new File("C:\\ActivityManager\\reportReaportOfAllUsers.txt");
	if(f.exists() && !f.isDirectory()) { 
		Assert.assertTrue(checker==true);
	}else {
		Assert.assertTrue(checker==false);
	}
	
	
	}
	
	@Test
	public void report_ByRating_Test() throws Exception { 
		List<OtherActivity> list = new ArrayList<>();
		list=admincontroller.getActivityByHighRating();
	Boolean checker;	
	checker=reportMaker.createReaportOfMostRating(list);
	Assert.assertTrue(checker==true);
	

	File f = new File("C:\\ActivityManager\\reportActivitesByRating.txt");
	if(f.exists() && !f.isDirectory()) { 
		Assert.assertTrue(checker==true);
	}else {
		Assert.assertTrue(checker==false);
	}
	
	
	}
	
	@Test
	public void report_UsersEmail_Test() throws Exception { // check the report of users email in specific activity
		
		// we add a new activity to the data base. create the report, check the file existence, then delete the activity from data base.
		
		Boolean checker;	
		admincontroller.addOtherActivity(other);
		checker=userController.RegisterUserToAvctivity(user, 0);
		Assert.assertTrue(checker==false);

		List<User> list = new ArrayList<>();
		
		list=admincontroller.getUsersInSpecificActivity(0);
	checker=reportMaker.createReaportOfUsersInSpecificActivity(list, 0);
	Assert.assertTrue(checker==true);
	

	File f = new File("C:\\ActivityManager\\Report_Specific_Activity.txt");
	if(f.exists() && !f.isDirectory()) { 
		Assert.assertTrue(checker==true);
	}else {
		Assert.assertTrue(checker==false);
	}
		
		
		checker=admincontroller.deleteActiviry(0);
		Assert.assertTrue(checker==true);
		
	}
	
	@Test
	public void addOtherActivityTest() { 
		
		Boolean checker;	
		OtherActivity temp=new OtherActivity(100, "tent", "tent", 2, 9, 66, "tent", "tent", "tent", "tent");
		checker=admincontroller.addOtherActivity(temp);
		Assert.assertTrue(checker==true);
	
		checker=admincontroller.deleteActiviry(100);
		Assert.assertTrue(checker==true);

		}
	
	@Test
	public void addHighSchoolActivityTest() { 
		
		Boolean checker;	
		HighSchoolActivity temp=new HighSchoolActivity(1000000, "test", "test", 2, 3, 55, "test", "test", "test", "test", 4, "test", "test");
		checker=admincontroller.addHighSchoolActivity(temp);
		Assert.assertTrue(checker==true);
	
		checker=admincontroller.deleteActiviry(1000000);
		Assert.assertTrue(checker==true);

		
		}
	
	@Test
	public void addElementarySchoolActivityTest() { 
		
		Boolean checker;	
		ElementarySchoolActivity temp=new ElementarySchoolActivity(990000, "test", "test", 0, 55, (double) 55, "test", "test", "test", "test", "test", "test", "test");
		checker=admincontroller.addElemetarySchoolActivity(temp);
		Assert.assertTrue(checker==true);
	
		checker=admincontroller.deleteActiviry(990000);
		Assert.assertTrue(checker==true);

		
		}
	
	@Test
	public void deleteUserFromActivityTest() { // a new activity is added to the DB(770000), then empty user is register to this activity.
		//we try to delete him from non exist activity(980000) and expect to get false, then try to delete him right and expect to get true. 
		
		Boolean checker;	
		ElementarySchoolActivity temp=new ElementarySchoolActivity(770000, "test", "test", 0, 55, (double) 55, "test", "test", "test", "test", "test", "test", "test");
		checker=admincontroller.addElemetarySchoolActivity(temp);
		Assert.assertTrue(checker==true);
	
		User tempUser=new User();
		try {
			checker=userController.RegisterUserToAvctivity(tempUser, 770000);
		} catch (Exception e) {

			e.printStackTrace();
		}
		Assert.assertTrue(checker==true);

		
		checker=admincontroller.deleteUserFromActivity("non", 980000);
		Assert.assertTrue(checker==false);

		checker=admincontroller.deleteUserFromActivity("non", 770000);
		Assert.assertTrue(checker==true);

	
		
		checker=admincontroller.deleteActiviry(770000);
		Assert.assertTrue(checker==true);

		
		}
	
	@Test
	public void deleteActivityTest() throws Exception { // we added activity to DB , delete it, and finally check if exist( expect false)
		
		Boolean checker;	
		OtherActivity temp=new OtherActivity(99900, "tent", "tent", 2, 9, 66, "tent", "tent", "tent", "tent");
		checker=admincontroller.addOtherActivity(temp);
		Assert.assertTrue(checker==true);
	
		checker=admincontroller.deleteActiviry(99900);
		Assert.assertTrue(checker==true);

		checker=admincontroller.IsActivityExsist(99900);
		Assert.assertTrue(checker==false);

		}
	
	@Test
	public void deleteReviewTest() throws Exception { // we try to delete review which is InValid expect to get false, then we add a temp review , try to delete and expect true.
		
		int serial;
		Boolean checker;	
		RatingAndReview temp=new RatingAndReview(9999999, "test", 10, 999999);
		
		
		checker=admincontroller.deleteReview(9999999);
		Assert.assertTrue(checker==false);

		
		OtherActivity temp3=new OtherActivity(78900, "tent", "tent", 2, 9, 66, "tent", "tent", "tent", "tent");
		checker=admincontroller.addOtherActivity(temp3);

		
		
		serial=userController.addRatingAndReview(temp, 8);
		
		checker=admincontroller.deleteReview(serial);
		Assert.assertTrue(checker==true);


		checker=admincontroller.deleteActiviry(78900);
		}
	
	
	

	
	
}
