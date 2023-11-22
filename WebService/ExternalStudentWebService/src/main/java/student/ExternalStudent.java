package student;

import java.rmi.Naming;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import common.IService;
import common.ITutor;

public class ExternalStudent {
	String User;
	String Mdp;
	String FullName;
	String University;
	public ExternalStudent()  {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUser() {
		return User;
	}
	public Tutors lookTByName(String firstname, String lastname){
		try {
			 IService tubalaa = (IService) Naming.lookup("rmi://localhost/TutorService");
			List t=new ArrayList<ITutor>();
			t=tubalaa.lookTByName(firstname,lastname);
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
			 IService tubalaa = (IService) Naming.lookup("rmi://localhost/TutorService");
			List t=new ArrayList<ITutor>();
			t=tubalaa.lookTByFirstName(firstname);
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
			 IService tubalaa = (IService) Naming.lookup("rmi://localhost/TutorService");
			List t=new ArrayList<ITutor>();
			t=tubalaa.lookTByLastName(lastname);
			System.out.println(((ITutor)t.stream().findFirst().get()).getMdp());
			System.out.println("aha");
			return new Tutors(t);
			 }
			 catch (Exception e) {
			 System.out.println("Trouble " + e);
			 }
		return null;
	} 
	public void bookAppointement(String fullName, String firstName, String lastName, String startt, String endd) {
		try {
	        HashMap<Instant, Instant> instantHashMap = new HashMap<>();
	        // Put the entries in the HashMap
	        Instant start = Instant.parse(startt);
	        Instant end = Instant.parse(endd);
	        instantHashMap.put(start, end);
			 IService s = (IService) Naming.lookup("rmi://localhost/TutorService");
			 //s.bookAppointment(fullName, firstName, lastName, instantHashMap);
			 }
			 catch (Exception e) {
			 System.out.println("Trouble " + e);
			 }
	}
	public Tutors lookTBySkill(String skill){
		try {
			 IService tubalaa = (IService) Naming.lookup("rmi://localhost/TutorService");
			List t=new ArrayList<ITutor>();
			t=tubalaa.lookTBySkill(skill);
			return new Tutors(t);
			 }
			 catch (Exception e) {
			 System.out.println("Trouble " + e);
			 }
		return null;
	}
	public Tutors getAllTutors(){
		try {
			IService tubalaa = (IService) Naming.lookup("rmi://localhost/TutorService");
			List t=new ArrayList<ITutor>();
			t=tubalaa.getAllTutors();
			return new Tutors(t);
			 }
			 catch (Exception e) {
			 System.out.println("Trouble " + e);
			 }
		return null;
	}
	public void setUser(String user) {
		User = user;
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
