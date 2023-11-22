package serverApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import common.ITutor;
import java.rmi.*;
import java.rmi.server.*;
public class Tutor extends UnicastRemoteObject implements ITutor {
	String User;
	String Mdp;
	String Firstname;
	String Lastname;
	double rate;
	List<String> WaitingList=new ArrayList<>();
	List<String> Skills=new ArrayList<>();
	HashMap< String,String > Availibality=new HashMap<>();
	public Tutor() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tutor(String user, String mdp) throws RemoteException {
		super();
		User = user;
		Mdp = mdp;
	}
	
	
	public Tutor(String user, String mdp, String firstname, String lastname) throws RemoteException {
		super();
		User = user;
		Mdp = mdp;
		Firstname = firstname;
		Lastname = lastname;
	}
	public String getUser() throws RemoteException{
		return User;
	}
	public void setUser(String user)throws RemoteException {
		this.User = user;
	}
	public String getMdp() throws RemoteException{
		return Mdp;
	}
	public void setMdp(String mdp) throws RemoteException{
		this.Mdp = mdp;
	}
	public String getFirstname() throws RemoteException{
		return Firstname;
	}
	public void setFirstname(String firstname)throws RemoteException {
		Firstname = firstname;
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String lastname) throws RemoteException{
		Lastname = lastname;
	}
	public double getRate() throws RemoteException{
		return rate;
	}
	public void setRate(double rate) throws RemoteException{
		this.rate = rate;
	}
	public List<String> getSkills() throws RemoteException{
		return Skills;
	}
	
	public void setSkills(List<String> skills)throws RemoteException {
		Skills = skills;
	}
	public HashMap< String,String > getAvailibality()throws RemoteException {
		return Availibality;
	}
	public void setAvailibality(HashMap< String,String >availibality)throws RemoteException {
		Availibality = availibality;
	}
	public List<String> getWaitingList() throws RemoteException {
		return WaitingList;
	}
	public void setWaitingList(List<String> waitingList)throws RemoteException {
		WaitingList = waitingList;
	}
}
