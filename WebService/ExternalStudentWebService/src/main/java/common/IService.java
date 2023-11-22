package common;

import java.rmi.*;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;



public interface IService extends Remote {
	public void register(String user, String mdp,String firstname, String lastname) throws RemoteException;
	public List<ITutor> lookTByName(String firstname, String lastname) throws RemoteException;
	public List<ITutor> lookTBySkill(String skill) throws RemoteException;
	public List<ITutor> getAllTutors() throws RemoteException;
	public void login(String user, String mdp) throws RemoteException;
	public List<ITutor> lookTByFirstName(String firstname) throws RemoteException;
	public List<ITutor> lookTByLastName(String firstname) throws RemoteException;
	public void bookAppointment(String fullName, String firstName, String lastName, String apt) throws RemoteException;
	//public void bookTutor(ITutor tutor, IStudent student) throws RemoteException;
}
