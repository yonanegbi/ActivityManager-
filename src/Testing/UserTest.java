package Testing;

//import java.sql.SQLException;


import org.junit.Assert;
import org.junit.jupiter.api.Test;

import controller.AdminController;
import controller.UserController;
import model.ActivityRepository;
import model.LogInRepository;
import model.OtherActivity;
import model.RatingAndReview;
//import model.RatingAndReviewRepository;
import model.User;

class UserTest {

	
	User inValid=new User(" "," "," "," ");
	User userValid=new User("or@gmail.com","123","or","0544378025");
	UserController userController=new UserController();
	LogInRepository logInRepository=new LogInRepository();
	ActivityRepository activityRepository= new ActivityRepository();
	AdminController admincontroller=new AdminController();
	OtherActivity otherAct=new OtherActivity(0, "test", "test", 5, 6, 0, "test", "test", "test", "test");

	
	
	@Test
	public void UserLogInValid() { 
		
		userValid=userController.signIn(userValid);
		Assert.assertEquals("or@gmail.com",userValid.getEmail());
	}

	@Test
	public void UserLogNotInValid() { 
		
		inValid=userController.signIn(inValid);
		Assert.assertEquals("non",inValid.getEmail());
	}
	
	@Test
	public void writeRatingAndReviewTest() { // we check if it possible to write a review for non exist activity and expect to get false
		//then we add a new temp activity, write a review and expect to get true.
		
		int bool;
		RatingAndReview temp=new RatingAndReview(555555, "test", 10, 0);
		bool=userController.addRatingAndReview(temp, 0);
		Assert.assertEquals(0, bool);  // because activity does not exist
		
		OtherActivity temp3=new OtherActivity(78900, "tent", "tent", 2, 9, 66, "tent", "tent", "tent", "tent");
		 admincontroller.addOtherActivity(temp3);
		
		
		RatingAndReview temp2=new RatingAndReview(78900, "test", 10, 0);
		bool=userController.addRatingAndReview(temp2, temp2.getActivityID());
		Assert.assertNotEquals(0, bool); 
		
		admincontroller.deleteReview(bool);
		
		admincontroller.deleteActiviry(78900);

		
	}
	
	
	@Test
	public void RegisterToActivityTest() throws Exception { 
	
	Boolean checker;	
	admincontroller.addOtherActivity(otherAct);
	checker=userController.RegisterUserToAvctivity(userValid, 0);
	Assert.assertTrue(checker==true);

	checker=userController.RegisterUserToAvctivity(userValid, 0);
	Assert.assertTrue(checker==false);
	
	checker=admincontroller.deleteActiviry(0);
	Assert.assertTrue(checker==true);

	
	
	}
	
	
	
	
	
	
	
	
}
