package student;

import java.rmi.Naming;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import common.IService;
import common.ITutor;

public class ExternalStudent {
	String Mail="";
	String Mdp="";
	String FullName="";
	String University="";
	public ExternalStudent()  {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUser() {
		return Mail;
	}
	public Tutors lookTByName(String firstname, String lastname){
		try {
			 IService tuts = (IService) Naming.lookup("rmi://localhost/TutorService");
			List t=new ArrayList<ITutor>();
			t=tuts.lookTByName(firstname,lastname);
			System.out.println(((ITutor)t.stream().findFirst().get()).getMdp());
			System.out.println("aha");
			return new Tutors(t);
			 }
			 catch (Exception e) {
			 System.out.println("Trouble " + e);
			 }
		return null;
	} 
	public Tutors lookTByFirstName(String firstname){
		try {
			 IService tuts = (IService) Naming.lookup("rmi://localhost/TutorService");
			List t=new ArrayList<ITutor>();
			t=tuts.lookTByFirstName(firstname);
			System.out.println(((ITutor)t.stream().findFirst().get()).getMdp());
			System.out.println("aha");
			return new Tutors(t);
			 }
			 catch (Exception e) {
			 System.out.println("Trouble " + e);
			 }
		return null;
	} 
	public Tutors lookTByLastName(String lastname){
		try {
			 IService tuts = (IService) Naming.lookup("rmi://localhost/TutorService");
			List t=new ArrayList<ITutor>();
			t=tuts.lookTByLastName(lastname);
			System.out.println(((ITutor)t.stream().findFirst().get()).getMdp());
			System.out.println("aha");
			return new Tutors(t);
			 }
			 catch (Exception e) {
			 System.out.println("Trouble " + e);
			 }
		return null;
	} 
	public String  bookAppointement(String mail, String fullName, String apt) {
		try {
			 IService s = (IService) Naming.lookup("rmi://localhost/TutorService");
			 return s.bookAppointment(mail, fullName, apt);
			 }
			 catch (Exception e) {
			 System.out.println("Trouble " + e);
			 }
		return "";
	}
	public Tutors lookTBySkill(String skill){
		try {
			 IService tuts = (IService) Naming.lookup("rmi://localhost/TutorService");
			List t=new ArrayList<ITutor>();
			t=tuts.lookTBySkill(skill);
			return new Tutors(t);
			 }
			 catch (Exception e) {
			 System.out.println("Trouble " + e);
			 }
		return null;
	}
	public void giveFeedback(String feedback, String mail) {
		try {
			 IService tuts = (IService) Naming.lookup("rmi://localhost/TutorService");
			 tuts.FeedBack(feedback, mail);

			 }
			 catch (Exception e) {
			 System.out.println("Trouble " + e);
			 }

	}
	public Tutors getAllTutors(){
		try {
			IService tuts = (IService) Naming.lookup("rmi://localhost/TutorService");
			List t=new ArrayList<ITutor>();
			t=tuts.getAllTutors();
			System.out.println(t);
			System.out.println(((ITutor)t.stream().findFirst().get()).getMdp());
			System.out.println("aha");
			return new Tutors(t);
			 }
			 catch (Exception e) {
			 System.out.println("Trouble " + e);
			 }
		return null;
	}
	public void setUser(String user) {
		Mail = user;
	}
	public String getMdp() {
		return Mdp;
	}
	public void setMdp(String mdp) {
		Mdp = mdp;
	}
	public String getFullName(){
		return FullName;
	}
	public void setFullName(String fullName) {
		FullName = fullName;
	}
	public String getUniversity() {
		return University;
	}
	public void setUniversity(String university) {
		University = university;
	}
}
