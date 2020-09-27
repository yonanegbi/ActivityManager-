package model;

public class RatingAndReview {


		// attributes

		private double rating;
		private String review;
		private int activityID;
		private int SerialNumber;

		// getters and setters
		
		public double getRating() {
			return rating;
		}
		public int getActivityID() {
			return activityID;
		}
		public  boolean setRating(double ratingInput) {
			if (ratingInput>10 || ratingInput<10 ) {
				return false;
			}
			this.rating = ratingInput;
			return true;
		}
		public String getReview() {
			return review;
		}
		public void setReview(String review) {
			this.review = review;
		}
		public void setActivityID(int activityID) {
			this.activityID = activityID;
		}
		@Override
		public String toString() {
			return ("  "+this.rating+"       |	"+"    "+this.review);
		}
		public int getSerialNumber() {
			return SerialNumber;
			
			
		}
		public void setSerialNumber(int serialNumber) {
			SerialNumber = serialNumber;
		}
		
		// con't
		
		public RatingAndReview() {
			activityID=0;
			review = "non";
			rating = 0;
			this.SerialNumber=0;
		}
		public RatingAndReview(int activityID,String review, double rating,int serial) {
			this.SerialNumber=serial;
			this.activityID= activityID;
			this.review = review;
			this.rating = rating;
		}
	
		
	}
	
	
	
	

