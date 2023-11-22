package common;
import java.rmi.*;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
public interface ITutor extends Remote {
	public String getUser() throws RemoteException;
	public void setUser(String user)throws RemoteException;
	public String getMdp() throws RemoteException;
	public void setMdp(String mdp) throws RemoteException;
	public void setFirstname(String firstname)throws RemoteException;
	public String getLastname()throws RemoteException;
	public void setLastname(String lastname)throws RemoteException;
	public double getRate()throws RemoteException;
	public void setRate(double rate)throws RemoteException;
	public List<String> getSkills()throws RemoteException;
	public void setSkills(List<String> skills)throws RemoteException;
	public HashMap< String,String > getAvailibality()throws RemoteException;
	public void setAvailibality(HashMap< String,String > availibality)throws RemoteException;
	public List<String> getWaitingList() throws RemoteException;
	public void setWaitingList(List<String> waitingList)throws RemoteException;
}
