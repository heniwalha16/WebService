package student;

import java.io.Serializable;

public class Tutor implements Serializable{
    String Mail = "";
    String Firstname = "";
    String Lastname = "";
    double rating;
    double rate;
    String[] WaitingList; // Change to arrasy
    String[] Skills; // Change to array
    String[][] Availability; // Change to array of arrays
	public Tutor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tutor(String mail, String firstname, String lastname, double rating, double rate, String[] waitingList,
			String[] skills, String[][] availability) {
		super();
		Mail = mail;
		Firstname = firstname;
		Lastname = lastname;
		this.rating = rating;
		this.rate = rate;
		WaitingList = waitingList;
		Skills = skills;
		Availability = availability;
	}
	public String getMail() {
		return Mail;
	}
	public void setMail(String mail) {
		Mail = mail;
	}
	public String getFirstname() {
		return Firstname;
	}
	public void setFirstname(String firstname) {
		Firstname = firstname;
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String lastname) {
		Lastname = lastname;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public String[] getWaitingList() {
		return WaitingList;
	}
	public void setWaitingList(String[] waitingList) {
		WaitingList = waitingList;
	}
	public String[] getSkills() {
		return Skills;
	}
	public void setSkills(String[] skills) {
		Skills = skills;
	}
	public String[][] getAvailability() {
		return Availability;
	}
	public void setAvailability(String[][] availability) {
		Availability = availability;
	}
    
}
