package model;

public abstract class EducationActivity extends Activity {

	
	// attributes
	private String teacher;
	private String profession;
	private String remoteClass;
	
	
	// C'tor + getter + setters
	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getRemoteClass() {
		return remoteClass;
	}

	public void setRemoteClass(String remoteClass) {
		this.remoteClass = remoteClass;
	}

	
	//c'tor
	public EducationActivity( ) 
	{
		super();
		this.teacher = "non";
		this.profession = "non";
		this.remoteClass = "non";
	}
	
	public EducationActivity(int activityID, String name, String location, int currentCapicity, int maxCapicity, double price,
			String description, String teacher,String porfession,String remoteClass) 
	{
		super(activityID,name, location, currentCapicity,maxCapicity, price, description);
		this.teacher=teacher;
		this.profession=porfession;
		this.remoteClass=remoteClass;
	}
	
	
	// methods
	public void showActivityInfo() {
		
	}
	

	
	
}
