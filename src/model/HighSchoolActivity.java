package model;


public class HighSchoolActivity extends EducationActivity {

	
	// attributes
	private int studyUnits;
	private String finalExam;
	private String schoolAssociation;
	
	// C'tor 
	public HighSchoolActivity() {
		super();
		this.studyUnits =0;
		this.finalExam = "non";
		this.schoolAssociation = "non";
		
	}
	public HighSchoolActivity(int id) {
		super();
		this.activityID=id;
		this.studyUnits =0;
		this.finalExam = "non";
		this.schoolAssociation = "non";
		
	}
	
	// get\set
	public int getStudyUnits() {
		
		
		return studyUnits;
	}

	public Boolean setStudyUnits(int studyUnits) {
		if (studyUnits<0 ||studyUnits>5 ) {
			this.studyUnits=0;
			return false;
		} else {
			this.studyUnits = studyUnits;
			return true;
		}
	}

	public String getFinalExam() {
		return finalExam;
	}

	public void setFinalExam(String finalExam) {
		this.finalExam = finalExam;
	}

	public String getSchoolAssociation() {
		return schoolAssociation;
	}

	public void setSchoolAssociation(String schoolAssociation) {
		this.schoolAssociation = schoolAssociation;
	}

	public HighSchoolActivity(int activityID, String name, String location, int currentCapicity, int maxCapicity, double price,
			String description, String teacher,String porfession,String remoteClass,int studyUnits , String finalExam,String schoolAssociation) 
	{
		super(activityID,name, location, currentCapicity,maxCapicity, price, description,teacher ,porfession, remoteClass);
		this.studyUnits=studyUnits;
		this.finalExam=finalExam;
		this.schoolAssociation=schoolAssociation;
	}
	
	
	
	
	// methods
	public void showActivityInfo() {
		System.out.println("Activity ID: "+this.activityID+" |Profession: "+this.getProfession()+" | Study Units: "+this.studyUnits+" | School association: "+this.schoolAssociation+" | Price: "+this.price+" | Teacher: "+this.getTeacher()+" | Location: "+this.location+" | Remote Class: "+this.getRemoteClass()+" | Bagrut oriented: "+this.finalExam+" | Description: "+this.description);
	}
	
	
	
	

	
	
}