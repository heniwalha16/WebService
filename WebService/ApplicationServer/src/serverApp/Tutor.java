package serverApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import common.ITutor;

import java.rmi.*;
import java.rmi.server.*;
public class Tutor extends UnicastRemoteObject implements ITutor {
	String Mail="";
	String Mdp="";
	String Firstname="";
	String Lastname="";	
	double rating;
	double nbFeedback;
	double rate;
	List<String> WaitingList=new ArrayList<>();
	List<String> Skills=new ArrayList<>();
	HashMap< String,String > Availability=new HashMap<>();
	public Tutor() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tutor(String mail, String mdp, String firstname, String lastname, double rating, double rate,
			List<String> waitingList, List<String> skills, HashMap<String, String> availability)
			throws RemoteException {
		super();
		Mail = mail;
		Mdp = mdp;
		Firstname = firstname;
		Lastname = lastname;
		this.rating = rating;
		this.rate = rate;
		WaitingList = waitingList;
		Skills = skills;
		Availability = availability;
	}
	public Tutor(String mail, String mdp) throws RemoteException {
		super();
		Mail = mail;
		Mdp = mdp;
	}
	
	
	public Tutor(String mail, String mdp, String firstname, String lastname) throws RemoteException {
		super();
		Mail = mail;
		Mdp = mdp;
		Firstname = firstname;
		Lastname = lastname;
	}
	public double getNbFeedback() throws RemoteException {
		return nbFeedback;
	}
	public void setNbFeedback(double nbFeedback)throws RemoteException  {
		this.nbFeedback = nbFeedback;
	}
	public double getRating() throws RemoteException {
		return rating;
	}
	public void setRating(double rating) throws RemoteException{
		this.rating = rating;
	}
	public String getMail() throws RemoteException {
		return Mail;
	}
	public void setMail(String mail) throws RemoteException{
		Mail = mail;
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
	public HashMap< String,String > getAvailability()throws RemoteException {
		return Availability;
	}
	public void setAvailability(HashMap< String,String >availibality)throws RemoteException {
		Availability = availibality;
	}
	public HashMap<String, String> getEmptyAvailability() throws RemoteException {
        HashMap<String, String> emptyAvailability = new HashMap<>();

        for (Map.Entry<String, String> entry : Availability.entrySet()) {
            if (entry.getValue().isEmpty()) {
                emptyAvailability.put(entry.getKey(), entry.getValue());
            }
        }

        return emptyAvailability;
    }
	public void addAvailability(String avt)throws RemoteException {
		if(!WaitingList.isEmpty()) {
			int startIndex = WaitingList.get(0).indexOf('<');
	        String extractedEmail =WaitingList.get(0).substring(startIndex + 1, WaitingList.get(0).length() - 1);
	        System.out.println(extractedEmail);
			Availability.put(WaitingList.get(0), avt);
			String body="Finally the waiting time is over your asked tutor is now available. You have been affected to the Tutor"+this.Firstname + this.Lastname+" from "+avt;
			System.out.println(body);
			WaitingList.remove(0);
			//sendMail mail = new sendMail(body,extractedEmail,"Tutor's Availability");
			//mail.sendMail();
		}
		else 
			Availability.put(avt,"" );
	}
	public List<String> getWaitingList() throws RemoteException {
		return WaitingList;
	}
	public void setWaitingList(List<String> waitingList)throws RemoteException {
		WaitingList = waitingList;
	}
	
}
