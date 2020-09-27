package model;


	
	public abstract class Activity {
		
		
		
		// attributes
		 protected int activityID; 
		 protected String name;
		 protected String location;
		 protected int currentCapicity;
		 protected int maxCapicity;
		 protected double price;
		 protected String description;
		
		
		 
		//  getter + setters	
		 
		public void setPrice(double price) {
			if (price<0) {
				this.price = 0;

			}
			else {
				this.price = price;

			}
		}
		
		public int getActivityID() {
			return activityID;
		}

		public void setActivityID(int activityID) {
			this.activityID = activityID;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public int getCurrentCapicity() {
			return currentCapicity;
		}

		public void setCurrentCapicity(int currentCapicity) {
			this.currentCapicity = currentCapicity;
		}

		public int getMaxCapicity() {
			return maxCapicity;
		}

		public void setMaxCapicity(int maxCapicity) {
			if (maxCapicity<=0) {
				this.maxCapicity = 0;

			}
			else {
				this.maxCapicity = maxCapicity;

			}
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		
		//c'tor
		
		
		public Activity() {
			this.activityID = 0;
			this.name = "non";
			this.location = "non";
			this.currentCapicity = 0;
			this.maxCapicity = 0;
			this.price = 0;
			this.description = "non";
		}
		
		public Activity(int activityID, String name, String location, int currentCapicity, int maxCapicity, double price,
				String description) {
			super();
			this.activityID = activityID;
			this.name = name;
			this.location = location;
			this.currentCapicity = currentCapicity;
			this.maxCapicity = maxCapicity;
			this.price = price;
			this.description = description;
		}
		
		
		// methods
		
		public void showActivityInfo() {
			
		}
		
		
	
	
}
