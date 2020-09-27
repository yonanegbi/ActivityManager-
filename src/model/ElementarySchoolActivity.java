package model;


public class ElementarySchoolActivity extends EducationActivity {
	
	// attributes
	
	private String certification;
	private String transport; // שירותי הסעות
	private String accessable; // נגישות
	
	
	
	// C'tor 
	
	public ElementarySchoolActivity() {
		super();
		this.certification = "non";
		this.transport = "non";
		this.accessable = "non";
		
	}

	public ElementarySchoolActivity(int id) {
		super();
		this.activityID=id;
		this.certification = "non";
		this.transport = "non";
		this.accessable = "non";
		
	}
	
	public ElementarySchoolActivity(int activityID, String name, String location, int currentCapicity, int maxCapicity, Double price,
			String description, String teacher,String porfession,String remoteClass,String certification , String transport,String accessable ) 
	{
		super(activityID,name, location, currentCapicity,maxCapicity, price, description,teacher ,porfession, remoteClass);
		this.certification=certification;
		this.transport=transport;
		this.accessable=accessable;
	}
	
	
	// gettes+setters
	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

	public String getTransport() {
		return transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}

	public String getAccessable() {
		return accessable;
	}

	public void setAccessable(String accessable) {
		this.accessable = accessable;
	}
	
	
	
	
	// methods
	
	public void showActivityInfo() {
		System.out.println("Activity ID: "+this.activityID+" |Profession: "+this.getProfession()+" | Teacher: "+this.getTeacher()+" | Reamote Class: "+this.getRemoteClass()+" | Price: "+this.price+" | Transportation: "+this.transport+" | Location: "+this.location+" | Accessibility: "+this.getAccessable()+" | Certification: "+this.certification+" | Description: "+this.description);

	}
	
	
	
	
	

}
