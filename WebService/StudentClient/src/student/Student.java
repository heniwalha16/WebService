package student;


import java.rmi.RemoteException;



import common.IStudent;


public class Student implements IStudent {
	String Mail="";
	String Mdp="";
	String FullName="";
	String University="";
	public String getMail() {
		return Mail;
	}
	public Student(String mail, String mdp, String fullName, String university)  {
		super();
		Mail = mail;
		Mdp = mdp;
		FullName = fullName;
		University = university;
	}
	public void setMail(String mail)  {
		Mail = mail;
	}
	public String getMdp() {
		return Mdp;
	}
	public void setMdp(String mdp){
		Mdp = mdp;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getFullName() {
		return FullName;
	}
	public void setFullName(String fullName) {
		FullName = fullName;
	}
	public String getUniversity(){
		return University;
	}
	public void setUniversity(String university) {
		University = university;
	}
}
