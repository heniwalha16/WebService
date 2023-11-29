package common;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.*;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;



public interface IService extends Remote {
	public String register(String mail, String mdp,String firstname, String lastname) throws RemoteException;
	public List<ITutor> lookTByName(String firstname, String lastname) throws RemoteException;
	public List<ITutor> lookTBySkill(String skill) throws RemoteException;
	public List<ITutor> getAllTutors() throws RemoteException;
	public String login(String mail, String mdp) throws RemoteException;
	public List<ITutor> lookTByFirstName(String firstname) throws RemoteException;
	public List<ITutor> lookTByLastName(String firstname) throws RemoteException;
	public String bookAppointment(String mail, String student, String apt) throws RemoteException;
	public void FeedBack(String feedback, String mail) throws RemoteException ,IOException;
	public ITutor retrieveElement(String mail) throws RemoteException ;
}
