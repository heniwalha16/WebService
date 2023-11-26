package student;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;

import common.IService;
import common.IStudent;
import common.ITutor;

public class Student extends UnicastRemoteObject implements IStudent {
	String Mail="";
	String Mdp="";
	String FullName="";
	String University="";
	public String getMail() throws RemoteException {
		return Mail;
	}
	public Student(String mail, String mdp, String fullName, String university) throws RemoteException {
		super();
		Mail = mail;
		Mdp = mdp;
		FullName = fullName;
		University = university;
	}
	public void setMail(String mail) throws RemoteException {
		Mail = mail;
	}
	public String getMdp() throws RemoteException{
		return Mdp;
	}
	public void setMdp(String mdp) throws RemoteException{
		Mdp = mdp;
	}
	public Student() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getFullName()throws RemoteException {
		return FullName;
	}
	public void setFullName(String fullName)throws RemoteException {
		FullName = fullName;
	}
	public String getUniversity() throws RemoteException {
		return University;
	}
	public void setUniversity(String university)throws RemoteException {
		University = university;
	}
}
