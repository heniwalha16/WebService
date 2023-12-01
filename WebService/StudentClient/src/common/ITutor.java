package common;
import java.rmi.*;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
public interface ITutor extends Remote {
	public String getMdp() throws RemoteException;
	public void setMdp(String mdp) throws RemoteException;
	public String getFirstname() throws RemoteException;
	public void setFirstname(String firstname)throws RemoteException;
	public String getLastname()throws RemoteException;
	public void setLastname(String lastname)throws RemoteException;
	public double getRate()throws RemoteException;
	public void setRate(double rate)throws RemoteException;
	public List<String> getSkills()throws RemoteException;
	public void setSkills(List<String> skills)throws RemoteException;
	public HashMap< String,String > getAvailability()throws RemoteException;
	public void setAvailability(HashMap< String,String > availibality)throws RemoteException;
	public List<String> getWaitingList() throws RemoteException;
	public void setWaitingList(List<String> waitingList)throws RemoteException;
	public String getMail() throws RemoteException;
	public void setMail(String mail) throws RemoteException;
	public void addAvailability(String avt)throws RemoteException;
	public double getNbFeedback() throws RemoteException;
	public void setNbFeedback(double nbFeedback)throws RemoteException ;
	public double getRating() throws RemoteException ;
	public void setRating(double rating) throws RemoteException;
	public HashMap<String, String> getEmptyAvailability() throws RemoteException;
}
