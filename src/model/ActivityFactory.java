package model;

public class ActivityFactory {
	
	
	 //use getAvtivity method to get object of type ActivityType(the input)
	   public Activity getAvtivity(String ActivityType){
	      if(ActivityType == null){
	         return null;
	      }		
	      if(ActivityType.equalsIgnoreCase("other")){
	         return new OtherActivity();
	         
	      } else if(ActivityType.equalsIgnoreCase("high school")){
	         return new HighSchoolActivity();
	         
	      } else if(ActivityType.equalsIgnoreCase("elementary school")){
	         return new ElementarySchoolActivity();
	      }
	      
	      return null;
	   }

}
